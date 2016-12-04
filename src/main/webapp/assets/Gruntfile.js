'use strict';

module.exports = function(grunt) {
	grunt.loadNpmTasks('grunt-contrib-less');
	grunt.loadNpmTasks('grunt-contrib-cssmin');

	var timepickerSrc = "bower_components/bootstrap-timepicker";

  grunt.initConfig({
    less: {
      development: {
        options: {
          paths: [timepickerSrc + "/css"]
        },
        files: {
          'bower_components/bootstrap-timepicker/css/timepicker.css': timepickerSrc + '/css/timepicker.less'
        }
      }
    },

    cssmin: {
      target: {
        files: [{
          expand: true,
          src: [timepickerSrc + '/css/timepicker.css'],
          dest: '',
          ext: '.min.css'
        }]
      }
    }

  });

  grunt.registerTask('default', ['less','cssmin']);
};
