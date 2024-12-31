import request from "@/api";

//新增用户
//查询用户列表
export function test(query){
    
    return request({
        //发送请求
        url:'/back_ssm/find',
        method:'get',
        params:query
    })
}