Insert into member values('tmdwls2805', '11bfdd79733872fe4b318003b4dd9018b852bce2d34ed937d0f3fb06b14da2d1', '박승진', 'qkrtmdwls280@gmail.com','01040702805','123','경기','안산','0','개발자', '개발자.png', '개발자.png' ,'D:/upload/profile/',now());
Insert into member values('admin', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', '박승진', 'admin@gmail.com','01040702805','123','경기','안산','0','관리자', 'profile.png', 'profile.png' ,'D:/upload/profile/',now());
Insert into product values(1, '채소', '양파', '국내산', '1500', '1망', '0', '양파.jpg', '양파.jpg', 'D:\\upload\\product\\', '1000');
Insert into product values(2, '육류', '돼지고기 목살', '국내산', '2300', '100g', '1000', '돼지고기 목살.jpg', '돼지고기 목살.jpg', 'D:\\upload\\product\\', '40');
Insert into product values(3, '과일', '자몽', '국내산', '1200', '1개', '1000', '자몽.jpg', '자몽.jpg', 'D:\\upload\\product\\', '30');
Insert into product values(4, '채소', '대파', '국내산', '1400', '1단', '1000', '대파.jpg', '대파.jpg', 'D:\\upload\\product\\', '20');
Insert into product values(5, '생선', '고등어', '국내산', '2400', '1마리', '1000', '고등어.jpg', '고등어.jpg', 'D:\\upload\\product\\', '10');
Insert into product values(6, '채소', '당근', '국내산', '800', '1개', '1000', '당근.jpg', '당근.jpg', 'D:\\upload\\product\\', '5');
Insert into product values(7, '기타', '미역', '국내산', '3000', '1봉지', '1000', '미역.webp', '미역.webp', 'D:\\upload\\product\\', '0');
Insert into product values(8, '과일', '사과', '국내산', '500', '1알', '1000', '사과.jpg', '사과.jpg', 'D:\\upload\\product\\', '0');
Insert into product values(9, '채소', '양배추', '국내산', '2000', '1개', '1000', '양배추.jpg', '양배추.jpg', 'D:\\upload\\product\\', '0');
Insert into product values(10, '육류', '양지머리', '국내산', '1300', '100g', '1000', '양지머리.jpg', '양지머리.jpg', 'D:\\upload\\product\\', '0');
Insert into product values(11, '소스', '참기름', '국내산', '4000', '1병', '1000', '참기름.jpg', '참기름.jpg', 'D:\\upload\\product\\', '0');
Insert into product values(12, '생선', '꽁치', '국내산', '2500', '1마리', '1000', '꽁치.jpg', '꽁치.jpg', 'D:\\upload\\product\\', '0');
Insert into cart values(1, 2, '돼지고기 목살.jpg', '돼지고기 목살', 1000, 'tmdwls2805', 1, 1000);
Insert into cart values(2, 3, '자몽.jpg', '자몽', 1000, 'tmdwls2805', 3, 3000); 
Insert into recipe values('tmdwls2805', '개발자', 1, '미역국 만들기', '저의 첫번째 요리, 미역국 만들기입니다.', '미역국.jpg', '미역국.jpg', 'D:/upload/recipe/', '국/탕', '일상', '끓이기', '소고기', '2인', '30분이내', '아무나', '끓인 후에 식히고 한 번더 끓여주면 더 맛있어집니다.', 0, now());
Insert into recipe values('tmdwls2805', '개발자', 2, '맛있는 순대볶음', '저의 두번째 요리,  순대볶음 만들기입니다.', '순대볶음.jpg', '순대볶음.jpg', 'D:/upload/recipe/', '메인반찬', '일상', '볶음', '가공식품류', '2인', '1시간이내', '아무나', '*개인적으로 깻잎을 넣으면 더 맛있습니다', 0, now());
Insert into recipe values('tmdwls2805', '개발자', 3, '잡채가 이렇게나 쉽다', '저의 세번째 요리, 잡채 만들기입니다.', '잡채.png', '잡채.png', 'D:/upload/recipe/', '메인반찬', '일상', '볶음', '기타', '4인', '30분이내', '아무나', '', 0, now());
Insert into recipe values('tmdwls2805', '개발자', 4, '돼지고기 김치찌개 끓이기', '저의 네번째 요리, 순대볶음 만들기입니다.', '김치찌개.jpg', '김치찌개.jpg', 'D:/upload/recipe/', '찌개', '일상', '끓이기', '돼지고기', '2인', '30분이내', '아무나', '신김치를 사용해주세요!', 0, now());
Insert into material values(1, 1, '재료');
Insert into material values(2, 2, '재료');
Insert into material values(2, 3, '양념');
Insert into material values(3, 4, '재료');
Insert into material values(3, 5, '양념재료');
Insert into material values(3, 6, '밑간재료');
Insert into material values(3, 7, '고기 표고버섯 밑간 재료');
Insert into material values(4, 8, '재료');

Insert into material2 values(1, 1, 1, '미역', '100g');
Insert into material2 values(1, 1, 2, '양지머리', '200g');
Insert into material2 values(1, 1, 3, '참기름', '3숟갈');
Insert into material2 values(1, 1, 4, '물', '500ml');
Insert into material2 values(1, 1, 5, '소금', '적당히');
Insert into material2 values(1, 1, 6, '간장', '적당히');
Insert into material2 values(2, 2, 7, '순대', '500g');
Insert into material2 values(2, 2, 8, '양파', '1개');
Insert into material2 values(2, 2, 9, '대파', '1대');
Insert into material2 values(2, 2, 10, '풋고추', '2개');
Insert into material2 values(2, 2, 11, '배추잎', '2개');
Insert into material2 values(2, 2, 12, '들기름', '2큰술');
Insert into material2 values(2, 2, 13, '소금', '약간');
Insert into material2 values(2, 3, 14, '다진마늘', '1큰술');
Insert into material2 values(2, 3, 15, '설탕', '1큰술');
Insert into material2 values(2, 3, 16, '고추가루', '1큰술');
Insert into material2 values(2, 3, 17, '맛술', '2큰술');
Insert into material2 values(2, 3, 18, '카레가루', '1큰술');
Insert into material2 values(2, 3, 19, '간장', '1큰술');
Insert into material2 values(2, 3, 20, '매실청', '2큰술');
Insert into material2 values(2, 3, 21, '고추장', '2큰술');
Insert into material2 values(2, 3, 22, '후추', '약간');
Insert into material2 values(3, 4, 23, '당면', '400g');
Insert into material2 values(3, 4, 24, '소고기', '200g');
Insert into material2 values(3, 4, 25, '부추', '한줌');
Insert into material2 values(3, 4, 26, '당근', '150g');
Insert into material2 values(3, 4, 27, '양파', '1개');
Insert into material2 values(3, 4, 28, '표고버섯', '3개');
Insert into material2 values(3, 4, 29, '소금', '약간');
Insert into material2 values(3, 5, 30, '간장', '7T');
Insert into material2 values(3, 5, 31, '설탕', '2T');
Insert into material2 values(3, 5, 32, '참기름', '2T');
Insert into material2 values(3, 5, 33, '깨소금', '1T');
Insert into material2 values(3, 5, 34, '부추', '적당히');
Insert into material2 values(3, 6, 35, '참치 액젓', '1T');
Insert into material2 values(3, 6, 36, '깨소금', '1T');
Insert into material2 values(3, 6, 37, '참기름', '1T');
Insert into material2 values(3, 7, 38, '간장', '2T');
Insert into material2 values(3, 7, 39, '다진 마늘', '1T');
Insert into material2 values(3, 7, 40, '후추', '약간');
Insert into material2 values(4, 8, 41, '김치', '적당히');
Insert into material2 values(4, 8, 42, '두부', '적당히');
Insert into material2 values(4, 8, 43, '생수', '적당히');
Insert into material2 values(4, 8, 44, '돼지고기', '적당히');
Insert into material2 values(4, 8, 45, '대파', '적당히');


Insert into recipeOrder values(1, 1, '소고기와 참기름을 넣고 약한 불로 볶아준다.');
Insert into recipeOrder values(1, 2, '미역을 넣고 같이 볶아준다.');
Insert into recipeOrder values(1, 3, '물을 넣어준다.');
Insert into recipeOrder values(1, 4, '간장과 소금을 넣어 간을 맞춰준다.');
Insert into recipeOrder values(1, 5, '적당히 끓여준다.');
Insert into recipeOrder values(2, 6, '굳어 있는 순대는 끓은물에 소금을 약간 넣고 데쳐 기름기를 제거해 주세요.');
Insert into recipeOrder values(2, 7, '배추잎,양파,대파,청양고추는 적당한크기로 썰어 주세요.');
Insert into recipeOrder values(2, 8, '위의 분량의 양념을 넣고 섞어 주세요.');
Insert into recipeOrder values(2, 9, '순대는 적당한크기로 썰어 주세요.');
Insert into recipeOrder values(2, 10, '팬에 들기름을 두르고 양파를 넣고 볶아 주세요.');
Insert into recipeOrder values(2, 11, '배추잎을 넣고 볶아 주세요.');
Insert into recipeOrder values(2, 12, '풋고추와 대파 순대 양념장을 넣고 볶아 주세요.');
Insert into recipeOrder values(2, 13, '완성 그릇에 담아 주세요.');
Insert into recipeOrder values(3, 14, '모든재료를 준비합니다');
Insert into recipeOrder values(3, 15, '당면은 미지근한 물에 30분 정도 담가서 불려줍니다');
Insert into recipeOrder values(3, 16, '소고기는 키친타월로 살살 눌러서 핏물을 제거해줍니다
불린 표고버섯도 물기를 제거한 다음 꼭 짜서 준비합니다~!~');
Insert into recipeOrder values(3, 17, '표고버섯과 소고기는 간장 2T 다진 마늘 1T 후추 약간으로 밑간을 해줍니다');
Insert into recipeOrder values(3, 18, '식용유 1T 둘러준 다음 양파를 볶으면서 소금도 1가 집 넣어줍니다');
Insert into recipeOrder values(3, 19, '당근도 소금 약간 넣고 볶아줍니다');
Insert into recipeOrder values(3, 20, '물이 팔팔 끓을 때 소금 1T을 넣고 부추를 데친 다음
찬물에 헹구어 참치 액과 깨소금으로 밑간을 해줍니다');
Insert into recipeOrder values(3, 21, '밑간 한 소고기와 표고버섯을 함께 볶아줍니다');
Insert into recipeOrder values(3, 22, '따로따로 볶아도 되지만 엷은색부터 차례대로 넣고 볶아도 됩니다');
Insert into recipeOrder values(3, 23, '물이 팔팔 끓을 때 #식용유 1T을 넣고 불린 당면을 넣고
#3분 정도(볶을 거라 오래 삶지 않았어요) 삶아서 찬물에 헹구어줍니다~!~
그래야 당면의 #전분기가 빠져서 덜 불게 할 수 있지요~!~');
Insert into recipeOrder values(3, 24, '당면 양념을 넣고 바글바글 끓여줍니다');
Insert into recipeOrder values(3, 25, '물에 헹구어 물기를 뺀 당면은 먹기 좋게 자른 다음
팔팔 끓는 양념에 넣고 물기가 없을 때까지 볶아줍니다
당면 먼저 양념에 볶다가 볶아놓은 모든 양념을 넣고
다시 한번 볶아준 다음 참기름과 깨소금을 넣고 마무리해줍니다');
Insert into recipeOrder values(3, 26, '그릇에 옮겨 담고 통깨도 솔솔 뿌려줍니다');
Insert into recipeOrder values(3, 27, '접시에 담은 뒤 계란 꽃을 올리고 통깨를 뿌려주면 맛있는 잡채 완성입니다');
Insert into recipeOrder values(4, 28, '시간있을때 김치를 먼저 익혀두세요. 냄비에 김치를 넣고 물이나 육수를 부어 중불에서 은근히 끓여주면 됩니다.');
Insert into recipeOrder values(4, 29, '고기는 맥주에 된장을 풀어 한번 삶아서 준비해둡니다. 냄새도 잡고 요리도 쉽고 빠르게 하기위한 전처리 과정이랍니다.');
Insert into recipeOrder values(4, 30, '냉장고에 미리 준비된 익힌 김치와 초벌로 익힌 돼지고기를 준비합니다.');
Insert into recipeOrder values(4, 31, '냄비에 익혀둔 김치와 고기를 넣어줍니다.');
Insert into recipeOrder values(4, 32, '생수나 육수를 붓고 끓여주세요.');
Insert into recipeOrder values(4, 33, '두부한모도 썰어 넣어줍니다.');
Insert into recipeOrder values(4, 34, '대파도 송송 썰어 넣어줍니다.');
Insert into recipeOrder values(4, 35, '10분만에 끓이는 김치찌개 완성.');