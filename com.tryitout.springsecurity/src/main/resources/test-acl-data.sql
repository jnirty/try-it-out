-- NOTE: the scenario is to lock the first category = 'Pet Apparel' on the list so that no one other than ROLE_ADMIN can view it

-- class
insert into acl_class (class) values ('com.example.security.data.Category');

-- role SIDs (SIDs can either be roles or users, principal column indicates if an entry is an individual principal or not)
insert into acl_sid (principal, sid) values (false, 'ROLE_USER');
insert into acl_sid (principal, sid) values (false, 'ROLE_ADMIN');

-- object identity
insert into acl_object_identity (object_id_class,object_id_identity,parent_object,owner_sid,entries_inheriting)
select cl.id, 1, null, sid.id, false
from acl_class cl, acl_sid sid
where cl.class='com.example.security.data.Category' and sid.sid='ROLE_ADMIN';

-- ACE list (add read access to object for admin role
-- mask == R
insert into acl_entry (acl_object_identity, ace_order, sid, mask, granting, audit_success, audit_failure)
select oi.id, 1, si.id, 1, true, true, true
from acl_object_identity oi, acl_sid si
where si.sid = 'ROLE_ADMIN';

commit;