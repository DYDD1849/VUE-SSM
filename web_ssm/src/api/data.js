import request from "@/api";

export function data(query){
    
    return request({
        //发送请求
        url:'data',
        method:'post',
        data:query
    })
}