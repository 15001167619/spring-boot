findByName
===
    * 根据用户名查询用户信息
    select * from user where 1=1
    @if(!isEmpty(userName)){
        and user_name = #userName#
    @}
findById
===
    * 根据用户Id查询
    select * from user where 1=1
    @if(!isEmpty(id)){
        and id = #id#
    @}
selectPageList
===
    * 用户信息分页列表
    select * from user where 1=1
    #use("search")#
    #use("sort")#
    #use("limit")#

search
===
    *搜索内容
    @if(!isEmpty(params.search)){
        and username like #'%'+params.search+'%'#
        or mobile like #'%'+params.search+'%'#
    @} 
sort
===
    @if(params.sort=='username'){
        order by username
        #use("order")#
    @}else if(params.sort=='mobile'){
        order by mobile
        #use("order")#
    @}else {
        order by create_time
        #use("order")#
    @}
order
===
    @if(params.order=='asc'){
        asc
    @}else{
        desc
    @}           
limit
===
    *分页
    @if(!isEmpty(params.offset)){
        limit #params.offset#   
    @}
    @if(!isEmpty(params.limit)){
        ,#params.limit#
    @}    