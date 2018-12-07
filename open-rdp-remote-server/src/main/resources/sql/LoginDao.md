queryUserLoginMessage
===
    
    select a.userid as usr
                , a.username
                , a.password as pwd
                , a.inherit as inherit
                , a.ip
                , a.port
                  from t_base_op_user a
                 where a.userid = #usr#



queryUserLicense
===

    select count(*) as License
      from 
      (
     select t2.userid, t2.username,t2.password,t1.ip,t1.port
      from (select tt.userid, tt.inherit, tt.password, tt.ip, tt.port
              from t_base_op_user tt
              left join t_base_op_user tt2
                on tt.inherit = tt2.userid
               and tt.type = 'user'
               and tt2.type = 'group') t1,
           (select * from t_base_op_user userlist where userlist.type = 'user') t2
     where t2.userid = t1.userid or t2.inherit = t1.userid
      )
       t
     where t.userid = #user#
       and t.password = #pwd#
       and (t.ip = #ip# or t.ip = '*')
       and (t.port = #port#
         or t.port = '*')