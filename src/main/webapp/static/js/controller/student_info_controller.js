'use strict';

app.factory('StudentInfo', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/SchoolManagement/studentinfo/studentinfolist/:userId', {userId: '@users.userId'},
                {
                    updateStudentInfo: {method: 'PUT'}
                }
        );
    }]);

app.factory('StudentRecordBs', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/SchoolManagement/studentinfo/studentrecordbslist/:userId', {userId: '@userId'},
                {
                    updateStudentrecordbs: {method: 'PUT'}
                }
        );
    }]);

app.factory('CommonSupport', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/SchoolManagement/studentinfo/service/:userId', {userId: '@userId'},
                {
                    updateStudentrecordbs: {method: 'PUT'}
                }
        );
    }]);


app.controller('StudentInfoController', ['$scope', '$rootScope', 'StudentInfo', 'StudentRecordBs', 'CommonSupport', function ($scope, $rootScope, StudentInfo, StudentRecordBs,CommonSupport) {
        //var user = "User";
//localStorage.setItem("user", "User");

        var ob = this;
        ob.clicked;
        ob.test;
        ob.errorMsg='Something Wrong ';
        ob.user = localStorage.getItem("user");
        ob.studentInfos = [];
        ob.studentInfo = new StudentInfo();
        ob.commonSupport=new CommonSupport();
        ob.studentInfo.users = {};
        ob.studentInfo.users.role = {};
        ob.studentInfo.users.role.roleId = localStorage.getItem("role");
        ob.studentRecordBs = new StudentRecordBs();
        ob.studentInfo.studentRecordBsList = [ob.studentRecordBs];
        //ob.studentRecordBs=new studentRecordBs();
        ob.idForDelete;
        ob.fetchAllStudentInfos = function () {
            ob.studentInfos = StudentInfo.query();
            ob.commonSupport=CommonSupport.get({userId: 1}, function (){});
        };
        ob.fetchAllStudentInfos();
        ob.addStudentInfo = function () {
            console.log('Inside save');

            if ($scope.studentInfoForm.$valid) {
                console.log(ob.studentInfo);
//                ob.studentInfo.$save(function (studentInfo) {
//                    console.log(studentInfo);
//                   $rootScope.successAllert(ob.studentInfo.users.firstName+' Saved Successfully');
//                    ob.reset();
//                    //ob.fetchAllStudentInfos();
//                },
//                        function (err) {
//                            console.log(err.status);
//                            $rootScope.errorAllert(ob.errorMsg+'during Save');
//                        }
//                );
            }
        };
        ob.editStudentInfo = function (id) {
            console.log('Inside edit: ' + id);
            ob.studentInfo = StudentInfo.get({userId: id}, function () {
                for (var i = 0; i < ob.studentInfo.studentRecordBsList.length; i++) {
                    ob.studentRecordBs = ob.studentInfo.studentRecordBsList[0];
                    ob.studentInfo.studentRecordBsList = [ob.studentRecordBs];
                    console.log("studentRecordBs:");
                    console.log(ob.studentRecordBs);
                    console.log("studentInfo:");
                    console.log(ob.studentInfo);
                }

                ob.flag = 'edit';
            });
        };
        ob.updateStudentInfoDetail = function () {
            console.log('Inside update');
//            console.log('studentRecordBs');
//            console.log(ob.studentRecordBs);
            ob.studentInfo.studentRecordBsList = [ob.studentRecordBs];
            delete ob.studentInfo.studentInfoId;
            console.log('studentInfo');
            console.log(ob.studentInfo);
            if ($scope.studentInfoForm.$valid) {
                ob.studentInfo.$updateStudentInfo(function (studentInfo) {
                    $rootScope.successAllert(ob.studentInfo.users.firstName+' Updated Successfully');
                    console.log("studentInfo:");
                    console.log(studentInfo);
                    ob.updatedId = studentInfo.users.userId;
                    ob.reset();
                   
                    ob.fetchAllStudentInfos();
                });
            }
        };
        ob.prepareDelete=function(studentInfo){
            ob.studentInfo=studentInfo;
            console.log('Inside prepareDelete'+ob.studentInfo.users.userId);
        };
        ob.deleteStudentInfo = function (id) {
            console.log('Inside delete'+ob.studentInfo.users.userId);
            ob.studentInfo = StudentInfo.delete({userId: ob.studentInfo.users.userId}, function () {
                ob.reset();
                $rootScope.successAllert(ob.studentInfo.users.firstName+' Deleted Successfully');
                ob.fetchAllStudentInfos();
            });
        };
        ob.reset = function () {
            ob.studentInfo = new StudentInfo();
            $scope.studentInfoForm.$setPristine();
        };
        ob.cancelUpdate = function (id) {
            ob.studentInfo = new StudentInfo();
            ob.flag = '';
            ob.fetchAllStudentInfos();
        };
        ob.addAdmin = function () {
            console.log('addAdmin clicked');
            localStorage.setItem("user", "Admin");
            localStorage.setItem("role", "1");
        };

        ob.addTeacher = function () {
            console.log('addTeacher clicked');
            localStorage.setItem("user", "Teacher");
            localStorage.setItem("role", "2");
        };

        ob.addOfficeStuff = function () {
            console.log('addOfficeStuff clicked');
            localStorage.setItem("user", "Office Stuff");
            localStorage.setItem("role", "3");
        };
        
        ob.addStudent = function () {
            console.log('addTeacher clicked');
            localStorage.setItem("user", "Student");
            localStorage.setItem("role", "4");
        };
        
        $scope.uploadFile = function (event) {
            console.log('uploadfile');
            var files = event.target.files;
            console.log(files);
            if (files.length > 0) {
                console.log("Ok");
                $('#fileName').text(files[0].name);
                $('#fileSize').text(files[0].size);

                console.log($('#fileSelected').val());
                $('#filePath').text($('#fileSelected').val());
                ob.studentInfo.users.imagePath = $('#fileSelected').val();
                // console.log('mozilla');
                //console.log($('input[type=file]').files[0].mozFullPath);
                console.log(ob.studentInfo.users);
            }
        };
        ob.getFilePath = function () {
            console.log('change');
            $scope.count++;
//            $('#fileSelected').on('change', function (evt) {
//                var files = $(evt.currentTarget).get(0).files;
//                if (files.length > 0) {
//                    console.log("Ok");
//                    $('#fileName').text(files[0].name);
//                    $('#fileSize').text(files[0].size);
//                    $('#filePath').text($('#fileSelected').val());
//                }
//            });
        };
    }]);


