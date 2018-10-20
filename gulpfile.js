'use strict';

var gulp     = require('gulp'),
    uglify   = require('gulp-uglify'),
    concat   = require('gulp-concat'),
    imagemin = require('gulp-imagemin'),
    csso     = require('gulp-csso'),
    sass     = require('gulp-sass'),
    bsync    = require('browser-sync').create(),
    reload   = bsync.reload,
    proxy    = require('http-proxy-middleware');

var srvProxy = proxy('/', {
    target: 'http://localhost:8080'
});

gulp.task('build', [
    'sass',
    'js',
    'lib',
    'images',
    'icons',
    'templates'
]);

gulp.task('icons', function() { 
    return gulp.src('./client/lib/fontawesome/fonts/**.*') 
        .pipe(gulp.dest('./src/main/resources/static/fonts/')); 
});


gulp.task('sass', function() { 
    return gulp.src('./client/styles/app.scss')
         .pipe(sass({style: 'compressed',
             loadPath: [
                 './client/styles/',
                 './client/lib/bootstrap-sass/assets/stylesheets',
                 './client/lib/fontawesome/scss']})
              .pipe(sass().on('error', sass.logError))) 
         .pipe(gulp.dest('./src/main/resources/static/css/'))
        .pipe(reload({stream: true})); 
});

gulp.task('js', function () {
    gulp.src([
        './client/app/app.js',
        './client/app/**/*.js'])
        .pipe(concat('main.js'))
        .pipe(gulp.dest('./src/main/resources/static/app/'));
});

gulp.task('lib', function () {
    gulp.src([
        './client/lib/jquery/dist/jquery.min.js',
        './client/lib/jquery-ui/jquery-ui.min.js',
        './client/lib/lodash/dist/lodash.min.js',
        './client/lib/angular/angular.min.js',
        './client/lib/angular-notify-toaster/toaster.js',
        './client/lib/angular-resource/angular-resource.min.js',
        './client/lib/angular-ui-router/release/angular-ui-router.min.js',
        './client/lib/ngstorage/ngStorage.min.js',
        './client/lib/localforage/dist/localforage.min.js',
        './client/lib/ng-table/dist/ng-table.min.js',
        './client/lib/angular-sanitize/angular-sanitize.min.js',
        './client/lib/angular-animate/angular-animate.min.js',
        './client/lib/angular-bootstrap/ui-bootstrap-tpls.min.js',
        './client/lib/angular-dialog-service/dist/dialogs.min.js',
        './client/lib/angular-ui-sortable/sortable.min.js'
    ])
        .pipe(concat('lib.js'))
        .pipe(uglify())
        .pipe(gulp.dest('./src/main/resources/static/lib/'))
});


gulp.task('images', function () {
    gulp.src('./client/images/**')
        .pipe(imagemin())
        .pipe(gulp.dest('./src/main/resources/static/images/'))

});

gulp.task('templates', function () {
    return gulp.src(['./client/**/*.html', '!./client/lib/**/*.html'])
        .pipe(gulp.dest('./src/main/resources/static/'));
});

gulp.task('watch', ['build'], function () {
    gulp.watch('./client/**/*.scss', ['sass']);
    gulp.watch('./client/app/**/*.js', ['js']).on('change', reload);
    gulp.watch('./client/images/**/*', ['images']).on('change', reload);
    gulp.watch('./client/**/*.html', ['templates']).on('change', reload);
});

gulp.task('default', ['watch'], function () {
    bsync.init({
        startPath: '/',
        browser: 'default',
        port: 3000,
        ui: {
            port: 3001
        },
        logConnections: false,
        ghostMode: false,
        server: {
            baseDir: 'src/main/resources/static',
            middleware: [
                function (req, res, next) {
                    if (/\/app/.test(req.url) || /\/css/.test(req.url) || /\/images/.test(req.url) || /\/fonts/.test(req.url)
                        || /\/lib/.test(req.url) || /\/$/.test(req.url)) {
                        return next()
                    } else {
                        return srvProxy(req, res, next)
                    }
                }
            ]
        }
    })
});