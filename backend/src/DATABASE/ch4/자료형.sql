
use market_db;

drop table if exists hongong4;	-- 테이블 존재시 삭제

create table hongong4(

	tinyint_col tinyint ,		-- tinyint 	1byte 	+- 128
    smallint_col smallint ,		-- smallint 2byte	+- 3만 정도
    int_col int ,				-- int		4byte	+- 21억 정도
    bigint_col bigint ,			-- bigint	8byte	+- 21억 이상
    char_col char(10) ,			-- char(1~255) 		문자 고정 길이
    varchar_col varchar(10) ,	-- varchar(1~16383) 문자 가변 길이
    text_col text ,				-- text 	: 1~65535 게시판 등
	longtext_col longtext ,		-- longtext : 1~42억
    blob_col blob , 			-- blob 	: 1~165535 사진 영상 등
    longblob_col longblob ,		-- longblob : 1~42억
    float_col float ,			-- float	: 소수점 7자리 표현
    double_col double ,			-- double	: 소수점 15자리 표현
    date_col date ,				-- date		: 날짜 [ YYYY-MM-DD ]
    time_cl time , 				-- time		: 시간 [ HH:MM:SS ]
    datetime_col datetime		-- datetime	: 날짜 및 시간 [ YYYY-MM-DD HH:MM:SS ]
    
);


select * from hongong4
















