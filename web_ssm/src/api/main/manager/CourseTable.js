import request from "@/api";
//新增用户
//查询用户列表
export function CourseTable(query){
    
    return request({
        //发送请求
        url:'/findAllCourse',
        method:'post',
        data:query
    })
}