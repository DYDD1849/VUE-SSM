import request from "@/api";
//新增用户
//查询用户列表
export function teacherTable(query){
    
    return request({
        //发送请求
        url:'/findAllTeacher',
        method:'post',
        data:query
    })
}