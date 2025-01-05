import request from "@/api";

//新增用户
//查询用户列表
export function teacherMain(query){
    
    return request({
        //发送请求
        url:'/findTeacherCourse',
        method:'post',
        data:query
    })
}

export function teacherEnterCourse(query){
    
    return request({
        //发送请求
        url:'/findStudentScore',
        method:'post',
        data:query
    })
}