import request from "@/api";

//新增用户
//查询用户列表
export function studentMain(query){
    
    return request({
        //发送请求
        url:'/findStudentCourse',
        method:'post',
        data:query
    })
}

export function searchStudentScore(query){
    
    return request({
        //发送请求
        url:'/searchStudentScore',
        method:'post',
        data:query
    })
}

