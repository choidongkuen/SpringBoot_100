
INSERT INTO USER_TABLE (id, name, email ,created_at, password, phone)
VALUES(default, '최동근','danaver12@daum.net',CURRENT_TIMESTAMP,'1212','010-9017-6902');

INSERT INTO USER_TABLE (id, name, email ,created_at, password, phone)
VALUES(default, '박건구','danaver13@daum.net',CURRENT_TIMESTAMP,'1201','010-2222-3333');

INSERT INTO USER_TABLE (id, name, email ,created_at, password, phone)
VALUES(default, '빙상민','danaver14@daum.net',CURRENT_TIMESTAMP,'120112','010-4444-5555');


INSERT INTO NOTICE(id, content, hits,likes,title,user_id, created_at)
VALUES(default, '내용1',0,0,'제목1',1,CURRENT_TIMESTAMP);

INSERT INTO NOTICE(id, content, hits,likes,title,user_id, created_at)
VALUES(default, '내용2',0,0,'제목2',1,CURRENT_TIMESTAMP);

INSERT INTO NOTICE_LIKE(id, USER_ID, NOTICE_ID)
VALUES (default, 1,1);

INSERT INTO NOTICE_LIKE(id, USER_ID, NOTICE_ID)
VALUES (default, 2,2);

INSERT INTO NOTICE_LIKE(id, USER_ID, NOTICE_ID)
VALUES (default, 1,2);

