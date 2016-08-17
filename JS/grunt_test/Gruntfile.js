//包装函数
module.exports = function(grunt){

	//任务配置，所有插件的配置信息
	grunt.initConfig({

		//获取 package.json
		pkg:grunt.file.readJSON('package.json'),

		//uglify插件的配置信息
		uglify:{
			options:{
				stripBanners:true,
				banner:'/*!<%=pkg.name%>-<%=pkg.version%>.js <%= grunt.template.today("yyyy-mm-dd") %> */'
			},
			build:{
				src:'src/test.js',
				dest:'build/<%=pkg.name%>-<%=pkg.version%>.js.min.js'
			}
		},

		jshint:{
			build:['Gruntfile.js','src/*.js'],
			options:{
				jshintrc : '.jshintrc'
			}
		},
		csslint:{
			build:['src/*.css'],
			options:{
				csslintrc : '.csslintrc'
			}
		},
		//watch自动化
        watch:{
            build:{
                files:['src/*.js','src/.css'],
                tasks:['jshint','csslint','uglify'],
                options:{spawn:false}
            }
        }


	});


	//告诉grunt我们将使用插件
	grunt.loadNpmTasks('grunt-contrib-uglify');
	grunt.loadNpmTasks('grunt-contrib-jshint');
	grunt.loadNpmTasks('grunt-contrib-csslint');
	grunt.loadNpmTasks('grunt-contrib-watch');
	// 告诉grunt当我们在终端中输入grunt是需要做些什么（注意先后顺序）
	grunt.registerTask('default',['jshint','uglify','watch']);

};