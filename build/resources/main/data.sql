
INSERT INTO USER_TABLE (id, name, email ,created_at, password, phone, user_status,lock_yn)
VALUES(default, '최동근','danaver12@daum.net',CURRENT_TIMESTAMP,'1212','010-9017-6902', 'USING',false);

INSERT INTO USER_TABLE (id, name, email ,created_at, password, phone, user_status,lock_yn)
VALUES(default, '박건구','danaver13@daum.net',CURRENT_TIMESTAMP,'1201','010-2222-3333', default,false);

INSERT INTO USER_TABLE (id, name, email ,created_at, password, phone, user_status,lock_yn)
VALUES(default, '빙상민','danaver14@daum.net',CURRENT_TIMESTAMP,'120112','010-4444-5555', default,false);


INSERT INTO NOTICE(id, content, hits,likes,title,user_id, created_at)
VALUES(default, '내용1',0,0,'제목1',1,CURRENT_TIMESTAMP);

INSERT INTO NOTICE(id, content, hits,likes,title,user_id, created_at)
VALUES(default, '내용2',0,0,'제목2',1,CURRENT_TIMESTAMP);

INSERT INTO NOTICE(id, content, hits,likes,title,user_id, created_at)
VALUES(default, '내용3',0,0,'제목3',3,CURRENT_TIMESTAMP);

INSERT INTO NOTICE(id, content, hits,likes,title,user_id, created_at)
VALUES(default, '내용4',0,0,'제목4',2,CURRENT_TIMESTAMP);


--
INSERT INTO NOTICE_LIKE(id, USER_ID, NOTICE_ID)
VALUES (default, 1,1);

INSERT INTO NOTICE_LIKE(id, USER_ID, NOTICE_ID)
VALUES (default, 2,2);

INSERT INTO NOTICE_LIKE(id, USER_ID, NOTICE_ID)
VALUES (default, 1,2);

INSERT INTO NOTICE_LIKE(id, USER_ID, NOTICE_ID)
VALUES (default, 3,1);

INSERT INTO NOTICE_LIKE(id, USER_ID, NOTICE_ID)
VALUES (default, 3,2);

INSERT INTO NOTICE_LIKE(id, USER_ID, NOTICE_ID)
VALUES (default, 3,3);


INSERT INTO USER_LOGIN_HISTORY(id, user_id, login_dt, ip_address)
VALUES (default, 1, CURRENT_TIMESTAMP, '127.0909.212');


INSERT INTO USER_LOGIN_HISTORY(id, user_id, login_dt, ip_address)
VALUES (default, 2, CURRENT_TIMESTAMP, '127.0909.777');


INSERT INTO USER_LOGIN_HISTORY(id, user_id, login_dt, ip_address)
VALUES (default, 3, CURRENT_TIMESTAMP, '127.0909.1111');

INSERT INTO BOARD_TYPE(id, name, created_at)
VALUES (default, '타입1', CURRENT_TIMESTAMP);
INSERT INTO BOARD_TYPE(id, name, created_at)
VALUES (default, '타입2', CURRENT_TIMESTAMP);



INSERT INTO BOARD(id, user_id, board_type_id, title, content, top_yn)
VALUES (default, 1, 1, '제목1','내용1',false);

INSERT INTO BOARD(id, user_id, board_type_id, title, content, top_yn)
VALUES (default, 2, 1, '제목2','내용2',false);

INSERT INTO BOARD(id, user_id, board_type_id, title, content, top_yn)
VALUES (default, 3, 1, '제목3','내용3',false);



