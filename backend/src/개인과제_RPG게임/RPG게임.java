package 개인과제_RPG게임;

import java.util.Random;
import java.util.Scanner;

public class RPG게임 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {

			// -- 변수 묶음 --
			int hp = 50;
			int mp = 20;
			int exp = 0;
			int gold = 0;
			int attack = 0;
			int lv = 5;
			int dm = 2;
			int ran = 0;
			int 전사스킬 = 5;
			int 마법사스킬 = 5;
			int 궁수스킬 = 5;
			int 몬스터A = 20;
			int 몬스터B = 40;
			int 몬스터C = 60;
			int 전직확인 = 0;
			String 전직 = "";

			// -- 변수 묶음 --

			String 캐릭터정보 = "null,null,10,20,0,0,전직미완료";

			System.out.println(" ⚔⚔⚔⚔⚔⚔⚔자바죽이기⚔⚔⚔⚔⚔⚔⚔⚔");
			System.out.println("⚔\t\t\t\t  ⚔\r\n" + "⚔\t　　ｏ\t\t\t  ⚔\r\n" + "⚔\t　　°\t\t\t  ⚔\r\n"
					+ "⚔\t　┳┳ ∩∩\t\t\t  ⚔\r\n" + "⚔\t　┃┃(･∀･)　☆　　★\t\t  ⚔\r\n" + "⚔\t┏┻┻┷━Ｏ ┏┷┓┏┷┓\t\t  ⚔\r\n"
					+ "⚔\t┃Welcome┠┨★┠┨☆┃\t  ⚔\r\n" + "⚔\t┗©━━©┛ ┗©┛┗©┛\t\t  ⚔");
			System.out.println(" ⚔⚔⚔ RPG게임에 오신것을 환영합니다 ⚔⚔⚔");
			System.out.println("     1. 캐릭터 생성 2. 로그인 3. 회원가입 ");
			int input = scanner.nextInt();

////////////////////////////////////////////////////////////////////////////////////////////////////
			if (input == 1) {

				System.out.println("▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀");
				System.out.println("\t        캐릭터생성");
				System.out.println("\t성별을 직접 입력하세요[남자/여자]");
				String x = scanner.next();
				System.out.println("\t캐릭터 아이디 입력해주세요!!");
				String name = scanner.next();
				System.out
						.println("\t선택하신 캐릭터의 성별은 '" + x + "'\n\t이름은 '" + name + "' 로 생성하시겠습니까?\n" + "\t      1.Y 2.N");
				int answer = scanner.nextInt();
				System.out.println("▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀");
				if (answer == 1 && x.equals("남자")) {

					System.out.print("\t　∧ ,, ∧\r\n" + "\t （´･ω･）　ヽヽ\r\n" + "\t　/つ　〇━⊂二二フ\r\n"
							+ " \t                  ⊂(  ‘ д’)つ\n");
					System.out.println("\t환영합니다!!");
					System.out.println("\t당신의 캐릭터의 성별은 '" + x + "'\n\t이름은 '" + name + "' 입니다");

					if (캐릭터정보.split(",")[0].equals("null")) {
						캐릭터정보 = "\t👉성별:" + x + "\n\t👉아이디:" + name + "\n\t👉HP :" + 캐릭터정보.split(",")[2] + "\n\t👉MP :"
								+ 캐릭터정보.split(",")[3] + "\n\t👉경험치 :" + 캐릭터정보.split(",")[4] + "\n\t👉골드 :"
								+ 캐릭터정보.split(",")[5] + "\n\t👉직업 :" + 캐릭터정보.split(",")[6];
					}
					System.out.println("\t╭◜◝ ͡ ◜◝╮\r\n" + "\t( ＊•◡•＊ )\r\n" + "\t╰◟◞ ͜ ◟◞╯\n" + "\t👉👉확인정보👈👈");
					System.out.println("\t人◕ ‿‿ ◕人");
					System.out.println(캐릭터정보);

				} // 남자 캐릭터 if E

				if (answer == 2) {
					System.out.println(" ____                         \r\n" + "/\\  _`\\                       \r\n"
							+ "\\ \\ \\L\\ \\   __  __       __   \r\n" + " \\ \\  _ <' /\\ \\/\\ \\    /'__`\\ \r\n"
							+ "  \\ \\ \\L\\ \\\\ \\ \\_\\ \\  /\\  __/ \r\n"
							+ "   \\ \\____/ \\/`____ \\ \\ \\____\\\r\n" + "    \\/___/   `/___/> \\ \\/____/\r\n"
							+ "                /\\___/        \r\n" + "                \\/__/         ");
					continue;
				}

				else if (answer == 1 && x.equals("여자")) {
					System.out.print(
							"　∧ ,, ∧\r\n" + " （´･ω･）　ヽヽ\r\n" + "　/つ　〇━⊂二二フ\r\n" + "                   ⊂(  ‘ д’)つ\n");
					System.out.println("\t==== 환영합니다!! ====");
					System.out.println("\t당신의 캐릭터의 성별은 '" + x + "'\n\t이름은 '" + name + "' 입니다\n");

					if (캐릭터정보.split(",")[0].equals("null")) {
						캐릭터정보 = "\t👉성별: " + x + "\n\t👉아이디:" + name + "\n\t👉HP : " + 캐릭터정보.split(",")[2] + "\n\t👉MP : "
								+ 캐릭터정보.split(",")[3] + "\n\t👉경험치 : " + 캐릭터정보.split(",")[4] + "\n\t👉골드 : "
								+ 캐릭터정보.split(",")[5] + "\n\t👉직업 : " + 캐릭터정보.split(",")[6];
					}
					System.out.println("\t╭◜◝ ͡ ◜◝╮\r\n" + "\t( ＊•◡•＊ )\r\n" + "\t╰◟◞ ͜ ◟◞╯\n" + "\t👉👉확인정보👈👈");
					System.out.println("\t人◕ ‿‿ ◕人");
					System.out.println(캐릭터정보);
				} // 여자 캐릭터 if E

				if (x.equals("남자") || x.equals("여자") && answer == 1) {
					System.out.println("\n\t╯▅╰╱▔▔▔▔▔▔▔╲╯╯☼\r\n" + "\t▕▕╱╱╱╱╱╱╱╱╱╲╲╭╭\r\n" + "\t▕▕╱╱╱╱╱╱╱╱┛▂╲╲╭\r\n"
							+ "\t╱▂▂▂▂▂▂╱╱┏▕╋▏╲╲\r\n" + "\t▔▏▂┗┓▂▕▔┛▂┏▔▂▕▔\r\n" + "\t▕▕╋▏▕╋▏▏▕┏▏▕╋▏▏\r\n"
							+ "\t▕┓▔┗┓▔┏▏▕┗▏┓▔┏▏");
					System.out.println();
					System.out.println("\t=> 마을에 오신걸 환영합니다🤚🤚");

					boolean 마을 = true;
					while (마을) {

						if (exp == 20) {
							System.out.println(" lv.1 up! ");
							hp += 2;
							mp += 4;

						}

						// 레벨5 전직 시작
						if (lv == 5 && 전직확인 == 0) {
							dm += 2;

							boolean B_job = true;
							while (true) {

								System.out.println("．\t 　 　 ∧ ∧ \r\n" + "\t　 　　(´･ω･ ∩\r\n" + "\t　　　o.　　 ,ﾉ. \r\n"
										+ "\t　 　　Ｏ＿ .ﾉ\r\n" + "\t　 　 　 　 (ノ\r\n" + "\t　 　 　　i｜|\r\n" + "\t　　　　 ━━");
								System.out.println("   LV.5 달성을 축하합니다! 직업을 직접 입력해주세요!");
								System.out.println("\t1. 전사  2. 마법사  3. 궁수");
								String job = scanner.next();

								if (job.equals("전사")) {

									System.out.println("\t당신은 전사를 선택하셨습니다 전직하시겠습니까?");
									System.out.println("\t획득내용 : 추가체력 = 5 , 전사 전용 스킬  ");
									System.out.println("\t1.전직한다  2.다시 생각해본다");
									int 전사 = scanner.nextInt();
									if (전사 == 1) {
										System.out.println(
												"\t∧,,∧ \r\n" + "\t( 'ω' )つ \r\n" + "\t（m9 ＼ \r\n" + "\t　 ＼　 ＼ \r\n"
														+ "\t　 　 ) ) ＼ \r\n" + "\t　 ／／ ＼ ＼ \r\n" + "\t　 (＿） 　 (＿)");
										System.out.println("   당신은 용사를  선택하셨습니다.");

										전사스킬 = (int) ((Math.random() * 4) + 1);
										hp += 5;

										if (캐릭터정보.split(",")[0].equals("null")) {
											캐릭터정보 = "👉성별: " + x + "\n👉아이디:" + name + "\n👉HP : " + 캐릭터정보.split(",")[2]
													+ "\n👉MP : " + 캐릭터정보.split(",")[3] + "\n👉경험치 : "
													+ 캐릭터정보.split(",")[4] + "\n👉골드 : " + 캐릭터정보.split(",")[5]
													+ "\n👉직업 : " + job;
										}
										전직확인 = 1;
										전직 = "전사";
										break;

									} // 전사 전직 1 if E
									else {
										B_job = false;
									}
								} // 전사 if E
								else if (job.equals("마법사")) {
									System.out.println("\t당신은 마법사를 선택하셨습니다 전직하시겠습니까?");
									System.out.println("\t획득내용 : 추가체력 = 5 , 마법사 전용 스킬  ");
									System.out.println("\t1.전직한다  2.다시 생각해본다");
									int 마법사 = scanner.nextInt();
									if (마법사 == 1) {
										System.out.println("\t   ∧＿∧  　           —̳͟͞͞⚾️         —̳͟͞͞⚾️\r\n"
												+ "\t( ·•︠‿•︡  )つ  —̳͟͞͞⚾️          —̳͟͞͞⚾️\r\n" + "\t(つ　 <  \r\n"
												+ "\t｜　 _つ                                         \r\n" + "\t`し´");
										System.out.println("   당신은 마법사를  선택하셨습니다.");
										마법사스킬 = (int) ((Math.random() * 3) + 1);
										hp += 5;
										if (캐릭터정보.split(",")[0].equals("null")) {
											캐릭터정보 = "👉성별: " + x + "\n👉아이디:" + name + "\n👉HP : " + 캐릭터정보.split(",")[2]
													+ "\n👉MP : " + 캐릭터정보.split(",")[3] + "\n👉경험치 : "
													+ 캐릭터정보.split(",")[4] + "\n👉골드 : " + 캐릭터정보.split(",")[5]
													+ "\n👉직업 : " + job;
										}
										전직확인 = 2;
										전직 = "마법사";
										break;
									} // 마법사 전직 1 if E
									break;
								} // 마법사 if E
								else if (job.equals("궁수")) {
									System.out.println("\t당신은 궁수를 선택하셨습니다 전직하시겠습니까?");
									System.out.println("\t획득내용 : 추가체력 = 5 , 궁수 전용 스킬  ");
									System.out.println("\t1.전직한다  2.다시 생각해본다");
									int 궁수 = scanner.nextInt();
									if (궁수 == 1) {

										System.out.println("\t...Λ＿Λ\r\n" + "\t（ㆍωㆍ)つ━☆*。\r\n" + "\t⊂　　 ノ 　　　.💕\r\n"
												+ "\t　し-Ｊ　　👼🏻　°。    *´¨)\r\n" + "\t　　　　　　..　.· ´¸.·✨*´¨)\r\n"
												+ "\t　　　　　　　　　　(¸.·´ °。   \r\n"
												+ "\t                                       *。💖¸.·*¨)");
										System.out.println("   당신은 궁수를  선택하셨습니다.");
										궁수스킬 = (int) ((Math.random() * 5) + 1);
										hp += 5;
										if (캐릭터정보.split(",")[0].equals("null")) {
											캐릭터정보 = "👉성별: " + x + "\n👉아이디:" + name + "\n👉HP : " + 캐릭터정보.split(",")[2]
													+ "\n👉MP : " + 캐릭터정보.split(",")[3] + "\n👉경험치 : "
													+ 캐릭터정보.split(",")[4] + "\n👉골드 : " + 캐릭터정보.split(",")[5]
													+ "\n👉직업 : " + job;
										}

										전직확인 = 3;
										전직 = "궁수";
									} // 궁수 전직 if E
									break;
								} // 궁수 if E

								else {
									System.out.println("\t제발 리스트에 있는것을 직접 입력해주세요ㅠㅠ");
									B_job = true;
								}
							} // Lv5 while E

						} // lv5일때 전직 E

						if (lv == 10) {
							dm += 2;

							System.out.println(" ____                         \r\n"
									+ "/\\  _`\\                       \r\n" + "\\ \\ \\L\\ \\   __  __       __   \r\n"
									+ " \\ \\  _ <' /\\ \\/\\ \\    /'__`\\ \r\n"
									+ "  \\ \\ \\L\\ \\\\ \\ \\_\\ \\  /\\  __/ \r\n"
									+ "   \\ \\____/ \\/`____ \\ \\ \\____\\\r\n"
									+ "    \\/___/   `/___/> \\ \\/____/\r\n" + "                /\\___/        \r\n"
									+ "                \\/__/         ");

						break;
						}

						System.out.println("\t⎛⎝(•‿•)⎠⎞⎛⎝(•‿•)⎠⎞태초마을⎛⎝(•‿•)⎠⎞⎛⎝(•‿•)⎠⎞");
						System.out.println("\t👉👉원하는 행동을 선택해주세요👈👈");
						System.out.println("\t1. 던전입장  2. 상점방문  3. 휴식 4. 상태확인");

						int home = scanner.nextInt();

						// ------------ 던전 입장 시 시작 ----------- //

						if (home == 1) {
							while (true) {

								System.out.println(
										"\t　　　　∧_∧\r\n" + "\t　　　 (･ω･ )\r\n" + "\t　　　ｏ┳o　）\r\n" + "\t　　　◎┻し'◎ ≡");
								System.out.println("\t1. A던전 입장\n\t2. B던전 입장\n\t3. C던전 입장\n\t4. 마을로 돌아가기 ");
								int hunt = scanner.nextInt();

								if (hunt == 1) { // 1번 A던전 선택

									while (true) {

										// String 몬스터_A = "몬스터A, HP:20, 획득가능 경험치 5";
										System.out.println(
												"\t  ∧ ∧\r\n" + "\t (´･ω･)  =3\r\n" + "\t /　 ⌒ヽ\r\n" + "\t(人＿＿つ_つ");
										System.out.println("\t몬스터A의 정보 : HP:20, 획득가능 경험치 5");
										System.out.println("\t✋날잡으러 왔나");
										System.out.println("\t1. 싸우자\n\t2. 숨어있기\n\t3. 필드로 돌아가기");

										int hunt_select = scanner.nextInt();

										if (hunt_select == 1) {

											ran = 0;

											System.out.println("\t ∧＿∧　  ∧_∧\r\n"
													+ "\t( ・ㅅ・)つ)゜Д゜)・゜\r\n"
													+ "\t(つ　丿  ⊂ 　⊂)'\r\n"
													+ "\t｜　 _つ ⊂_⊂ノ\r\n"
													+ "\tし´");
											System.out.println("\t몬스터를 사냥하세요!");

											boolean 변수 = true;
											while (변수) {
												System.out.println("\t1. 공격하기\n\t2. 스킬사용\n\t3. 도망가기");

												int battle = scanner.nextInt();

												if (battle == 1) { // 1번 공격하기 선택
													System.out.println("\t✊ 몬스터A를 공격했다! ✊");

													attack++;
													// System.out.println("✊✊때린 횟수 : " + attack );

													// 두대 때리고 한대 맞기

													System.out.println("\t몬스터A에게 공격당했다ㅠㅠ");

													ran = (int) ((Math.random() * 4) + 1);

													System.out.println("\t몬스터가 가한 피해 : " + ran);

													hp -= ran;
													몬스터A -= dm;

													System.out.println("\t내 현재 HP : " + hp);
													System.out.println("\t몬스터 현재 HP : " + 몬스터A);

													if (attack == 10) {
														exp += 5;
														gold++;
														System.out.println("\t경험치 " + exp + " 획득\n\t골드 " + gold + " 획득");
														System.out.println("\t．．．．．/)─―ヘ\r\n" + "\t　　　━／　　　　＼\r\n"
																+ "\t ／　　　　●　　●丶\r\n" + "\t　｜　　　　　　　▼　| \r\n"
																+ "\t　｜　　　　　　　亠ノ 　\r\n" + "\t　 U￣U￣￣￣U￣￣U");

														System.out.println("\t날죽이다니..\n");
														변수 = false;
														break;
													} // if 종료

													if (hp <= 0) {
														System.out.println("\t사망했습니다 마을로 돌아가자");
														exp -= 2;
														gold -= 1;

														마을 = false;
														break;
													}

													if (몬스터A <= 0) {
														exp += 5;
														gold++;
														System.out.println("\t경험치 " + exp + " 획득\n\t골드 " + gold + " 획득");
														System.out.println("\t．．．．．/)─―ヘ\r\n" + "\t　　　━／　　　　＼\r\n"
																+ "\t ／　　　　●　　●丶\r\n" + "\t　｜　　　　　　　▼　| \r\n"
																+ "\t　｜　　　　　　　亠ノ 　\r\n" + "\t　 U￣U￣￣￣U￣￣U");

														System.out.println("\t날죽이다니..\n");
														break;
													}
													continue; // 전투를 계속할지 말지 선택할 수 있도록

												} // battle 1번 공격하기 if 종료

												else if (battle == 2) { // 2번 스킬사용 선택
													
													if (전직확인 == 1) {

														몬스터A -= 전사스킬;
														ran = (int) ((Math.random() * 4) + 1);
														hp -= ran;
														System.out.println("\t검휘두르기 데미지 : " + 전사스킬);
														System.out.println("\t몬스터가 가한 피해 : " + ran);
														System.out.println("\t내 체력 " + hp);
														System.out.println("\t몬스터A 체력 " + 몬스터A);

														if (hp <= 0) {
															System.out.println("\t사망했습니다 마을로 돌아가자");
															exp -= 2;
															gold -= 1;

															마을 = false;
															break;
														}

														if (몬스터A <= 0) {
															exp += 5;
															gold++;
															
															System.out.println("\t경험치 " + exp + " 획득\n\t골드 " + gold + " 획득");
															System.out.println("\t．．．．．/)─―ヘ\r\n" + "\t　　　━／　　　　＼\r\n"
																	+ "\t ／　　　　●　　●丶\r\n" + "\t　｜　　　　　　　▼　| \r\n"
																	+ "\t　｜　　　　　　　亠ノ 　\r\n" + "\t　 U￣U￣￣￣U￣￣U");

															System.out.println("\t날죽이다니..\n");
															break;
														}

													}

													if (전직확인 == 2) {

														몬스터A -= 마법사스킬;
														ran = (int) ((Math.random() * 4) + 1);
														hp -= ran;

														System.out.println("\t파이어볼 데미지 : " + 마법사스킬);
														System.out.println("\t몬스터가 가한 피해 : " + ran);
														System.out.println("\t내 체력 " + hp);
														System.out.println("\t몬스터A 체력 " + 몬스터A);

														if (hp <= 0) {
															System.out.println("\t사망했습니다 마을로 돌아가자");
															exp -= 2;
															gold -= 1;

															마을 = false;
															break;
														}

														if (몬스터A <= 0) {
															exp += 5;
															gold++;
															
															System.out.println("\t경험치 " + exp + " 획득\n\t골드 " + gold + " 획득");
															System.out.println("\t．．．．．/)─―ヘ\r\n" + "\t　　　━／　　　　＼\r\n"
																	+ "\t ／　　　　●　　●丶\r\n" + "\t　｜　　　　　　　▼　| \r\n"
																	+ "\t　｜　　　　　　　亠ノ 　\r\n" + "\t　 U￣U￣￣￣U￣￣U");

															System.out.println("\t날죽이다니..\n");
															break;
														}
													}

													if (전직확인 == 3) {

														몬스터A -= 궁수스킬;
														ran = (int) ((Math.random() * 4) + 1);
														hp -= ran;

														System.out.println("\t활쏘기 데미지 : " + 궁수스킬);
														System.out.println("\t몬스터가 가한 피해 : " + ran);
														System.out.println("\t내 체력 " + hp);
														System.out.println("\t몬스터A 체력 " + 몬스터A);

														if (hp <= 0) {
															System.out.println("\t사망했습니다 마을로 돌아가자");
															exp -= 2;
															gold -= 1;

															마을 = false;
															break;
														}

														if (몬스터A <= 0) {
															exp += 5;
															gold++;
															
															System.out.println("\t경험치 " + exp + " 획득\n\t골드 " + gold + " 획득");
															System.out.println("\t．．．．．/)─―ヘ\r\n" + "\t　　　━／　　　　＼\r\n"
																	+ "\t ／　　　　●　　●丶\r\n" + "\t　｜　　　　　　　▼　| \r\n"
																	+ "\t　｜　　　　　　　亠ノ 　\r\n" + "\t　 U￣U￣￣￣U￣￣U");

															System.out.println("\t날죽이다니..\n");
															break;
														}
													}
													else {
														System.out.println("\t*｡*.。*∧,,,∧\r\n"
																+ "\t  ヾ(⌒(_=•ω•)_");
														System.out.println("\t스킬은 전직 후 사용가능하다구!");
													}
													

													continue;
												} // battle 2번 스킬사용 else if 종료

												else if (battle == 3) { // 3번 도망가기 선택
													System.out.println("\tᕕ( ˃̣̣̥᷄⌓˂̣̣̥᷅ )ᕗ");
													System.out.println("\t필드로 도망갑니다..!\n");

													break;
												} // battle 3번 도망가기 else if 종료

												else {
													System.out.println("\t다시 선택하세요!");
													continue;
												} // battle else 종료

											} // while

										} // hunt_select 1번 전투 if 종료

										else if (hunt_select == 2) { // 2번 숨어있기 선택
											System.out.println("\t|∧_∧\r\n"
													+ "\t|'ㅅ')\r\n"
													+ "\t|⊂ ノ\r\n"
													+ "\t| \n\t숨어있자!\n");
											continue;

										} // hunt_select 2번 숨어있기 else if 종료

										else if (hunt_select == 3) { // 3번 마을로 돌아가기 선택
											break;

										} // hunt_select 3번 마을로가기 else if 종료

									} // hunt 1번 A던전 if 종료

								} // 전투 while 종료

								else if (hunt == 2) { // 2번 B던전 선택

									// =============================
									while (true) {

										// String 몬스터_B = "몬스터B, HP:20, 획득가능 경험치 4";
										System.out.println(
												"\t  ∧ ∧\r\n" + "\t (´･ω･)  =3\r\n" + "\t /　 ⌒ヽ\r\n" + "\t(人＿＿つ_つ");
										System.out.println("\t몬스터B의 정보 : HP:20, 획득가능 경험치 4");
										System.out.println("\t✋날잡으러 왔나");
										System.out.println("\t1. 싸우자\n\t2. 숨어있기\n\t3. 필드로 돌아가기");

										int hunt_select = scanner.nextInt();

										if (hunt_select == 1) {

											ran = 0;

											System.out.println("\t ∧＿∧　  ∧_∧\r\n"
													+ "\t( ・ㅅ・)つ)゜Д゜)・゜\r\n"
													+ "\t(つ　丿  ⊂ 　⊂)'\r\n"
													+ "\t｜　 _つ ⊂_⊂ノ\r\n"
													+ "\tし´");
											System.out.println("\t몬스터를 사냥하세요!");

											boolean 변수 = true;
											while (변수) {
												System.out.println("\t1. 공격하기\n\t2. 스킬사용\n\t3. 도망가기");

												int battle = scanner.nextInt();

												if (battle == 1) { // 1번 공격하기 선택
													System.out.println("\t✊ 몬스터B를 공격했다! ✊");

													attack++;
													// System.out.println("✊✊때린 횟수 : " + attack );

													// 두대 때리고 한대 맞기

													System.out.println("\t몬스터B에게 공격당했다ㅠㅠ");

													ran = (int) ((Math.random() * 4) + 1);

													System.out.println("\t몬스터가 가한 피해 : " + ran);

													hp -= ran;
													몬스터B -= dm;

													System.out.println("\t내 현재 HP : " + hp);
													System.out.println("\t몬스터 현재 HP : " + 몬스터B);

													if (attack == 10) {
														exp += 4;
														gold += 2;
														
														System.out.println("\t경험치 " + exp + " 획득\n\t골드 " + gold + " 획득");
														System.out.println("\t．．．．．/)─―ヘ\r\n" + "\t　　　━／　　　　＼\r\n"
																+ "\t ／　　　　●　　●丶\r\n" + "\t　｜　　　　　　　▼　| \r\n"
																+ "\t　｜　　　　　　　亠ノ 　\r\n" + "\t　 U￣U￣￣￣U￣￣U");

														System.out.println("\t날죽이다니..\n");
														변수 = false;
														break;
													} // if 종료

													if (hp <= 0) {
														System.out.println("\t사망했습니다 마을로 돌아가자");
														exp -= 2;
														gold -= 1;

														마을 = false;
														break;
													}

													if (몬스터B <= 0) {
														exp += 4;
														gold += 2;
														
														System.out.println("\t경험치 " + exp + " 획득\n골드 " + gold + " 획득");
														System.out.println("\t．．．．．/)─―ヘ\r\n" + "\t　　　━／　　　　＼\r\n"
																+ "\t ／　　　　●　　●丶\r\n" + "\t　｜　　　　　　　▼　| \r\n"
																+ "\t　｜　　　　　　　亠ノ 　\r\n" + "\t　 U￣U￣￣￣U￣￣U");

														System.out.println("\t날죽이다니..\n");
														break;
													}

													continue; // 전투를 계속할지 말지 선택할 수 있도록

												} // battle 1번 공격하기 if 종료

												else if (battle == 2) { // 2번 스킬사용 선택

													if (전직확인 == 1) {

														몬스터B -= 전사스킬;
														ran = (int) ((Math.random() * 4) + 1);
														hp -= ran;
														System.out.println("\t검휘두르기 데미지 : " + 전사스킬);
														System.out.println("\t몬스터가 가한 피해 : " + ran);
														System.out.println("\t내 체력 " + hp);
														System.out.println("\t몬스터B 체력 " + 몬스터B);

														if (hp <= 0) {
															System.out.println("\t사망했습니다 마을로 돌아가자");
															exp -= 2;
															gold -= 1;

															마을 = false;
															break;
														}

														if (몬스터B <= 0) {
															exp += 4;
															gold += 2;
															
															System.out.println("\t경험치 " + exp + " 획득\n골드 " + gold + " 획득");
															System.out.println("\t．．．．．/)─―ヘ\r\n" + "\t　　　━／　　　　＼\r\n"
																	+ "\t ／　　　　●　　●丶\r\n" + "\t　｜　　　　　　　▼　| \r\n"
																	+ "\t　｜　　　　　　　亠ノ 　\r\n" + "\t　 U￣U￣￣￣U￣￣U");

															System.out.println("\t날죽이다니..\n");
															break;
														}

													}

													if (전직확인 == 2) {

														몬스터B -= 마법사스킬;
														ran = (int) ((Math.random() * 4) + 1);
														hp -= ran;

														System.out.println("\t파이어볼 데미지 : " + 마법사스킬);
														System.out.println("\t몬스터가 가한 피해 : " + ran);
														System.out.println("\t내 체력 " + hp);
														System.out.println("\t몬스터A 체력 " + 몬스터B);

														if (hp <= 0) {
															System.out.println("\t사망했습니다 마을로 돌아가자");
															exp -= 2;
															gold -= 1;

															마을 = false;
															break;
														}

														if (몬스터B <= 0) {
															exp += 4;
															gold += 2;
															
															System.out.println("\t경험치 " + exp + " 획득\n골드 " + gold + " 획득");
															System.out.println("\t．．．．．/)─―ヘ\r\n" + "\t　　　━／　　　　＼\r\n"
																	+ "\t ／　　　　●　　●丶\r\n" + "\t　｜　　　　　　　▼　| \r\n"
																	+ "\t　｜　　　　　　　亠ノ 　\r\n" + "\t　 U￣U￣￣￣U￣￣U");

															System.out.println("\t날죽이다니..\n");
															break;
														}
													}

													if (전직확인 == 3) {

														몬스터B -= 궁수스킬;
														ran = (int) ((Math.random() * 4) + 1);
														hp -= ran;

														System.out.println("\t활쏘기 데미지 : " + 궁수스킬);
														System.out.println("\t몬스터가 가한 피해 : " + ran);
														System.out.println("\t내 체력 " + hp);
														System.out.println("\t몬스터A 체력 " + 몬스터B);

														if (hp <= 0) {
															System.out.println("\t사망했습니다 마을로 돌아가자");
															exp -= 2;
															gold -= 1;

															마을 = false;
															break;
														}

														if (몬스터B <= 0) {
															exp += 4;
															gold += 2;
															
															System.out.println("\t경험치 " + exp + " 획득\n골드 " + gold + " 획득");
															System.out.println("\t．．．．．/)─―ヘ\r\n" + "\t　　　━／　　　　＼\r\n"
																	+ "\t ／　　　　●　　●丶\r\n" + "\t　｜　　　　　　　▼　| \r\n"
																	+ "\t　｜　　　　　　　亠ノ 　\r\n" + "\t　 U￣U￣￣￣U￣￣U");

															System.out.println("\t날죽이다니..\n");
															break;
														}
													}
													else {
														System.out.println("\t*｡*.。*∧,,,∧\r\n"
																+ "\t  ヾ(⌒(_=•ω•)_");
														System.out.println("\t스킬은 전직 후 사용가능하다구!");
													}

													continue;
												} // battle 2번 스킬사용 else if 종료

												else if (battle == 3) { // 3번 도망가기 선택
													System.out.println("\tᕕ( ˃̣̣̥᷄⌓˂̣̣̥᷅ )ᕗ");
													System.out.println("\t필드로 도망갑니다..!\n");

													break;
												} // battle 3번 도망가기 else if 종료

												else {
													System.out.println("\t다시 선택하세요!");
													continue;
												} // battle else 종료

											} // while

										} // hunt_select 1번 전투 if 종료

										else if (hunt_select == 2) { // 2번 숨어있기 선택
											System.out.println("\t|∧_∧\r\n"
													+ "\t|'ㅅ')\r\n"
													+ "\t|⊂ ノ\r\n"
													+ "\t| \n\t숨어있자!\n");
											continue;

										} // hunt_select 2번 숨어있기 else if 종료

										else if (hunt_select == 3) { // 3번 마을로 돌아가기 선택
											break;

										} // hunt_select 3번 마을로가기 else if 종료
									} // 전투 while 종료

									// =============================

								} // hunt 2번 else if 종료

								else if (hunt == 3) { // 3번 C던전 선택

									// =============================
									while (true) {

										//String 몬스터_C = "\t몬스터C, HP:20, 획득가능 경험치 2";
										
										System.out.println(
												"\t  ∧ ∧\r\n" + "\t (´･ω･)  =3\r\n" + "\t /　 ⌒ヽ\r\n" + "\t(人＿＿つ_つ");
										System.out.println("\t몬스터C의 정보 : HP:20, 획득가능 경험치 2");
										System.out.println("\t✋날잡으러 왔나");
										System.out.println("\t1. 싸우자\n\t2. 숨어있기\n\t3. 필드로 돌아가기");

										int hunt_select = scanner.nextInt();

										if (hunt_select == 1) {

											ran = 0;

											System.out.println("\t ∧＿∧　  ∧_∧\r\n"
													+ "\t( ・ㅅ・)つ)゜Д゜)・゜\r\n"
													+ "\t(つ　丿  ⊂ 　⊂)'\r\n"
													+ "\t｜　 _つ ⊂_⊂ノ\r\n"
													+ "\tし´");
											System.out.println("\t몬스터를 사냥하세요!");

											boolean 변수 = true;
											while (변수) {
												System.out.println("\t1. 공격하기\n\t2. 스킬사용\n\t3. 도망가기");

												int battle = scanner.nextInt();

												if (battle == 1) { // 1번 공격하기 선택
													System.out.println("\t✊ 몬스터C를 공격했다! ✊");

													attack++;
													// System.out.println("✊✊때린 횟수 : " + attack );

													// 두대 때리고 한대 맞기

													System.out.println("\t몬스터C에게 공격당했다ㅠㅠ");

													ran = (int) ((Math.random() * 4) + 1);

													System.out.println("\t몬스터가 가한 피해 : " + ran);

													hp -= ran;
													몬스터C -= dm;

													System.out.println("\t내 현재 HP : " + hp);
													System.out.println("\t몬스터 현재 HP : " + 몬스터C);

													if (몬스터C <= 0) {
														exp += 2;
														gold += 3;
														
														System.out.println("\t경험치 " + exp + " 획득\n골드 " + gold + " 획득");
														System.out.println("\t．．．．．/)─―ヘ\r\n" + "\t　　　━／　　　　＼\r\n"
																+ "\t ／　　　　●　　●丶\r\n" + "\t　｜　　　　　　　▼　| \r\n"
																+ "\t　｜　　　　　　　亠ノ 　\r\n" + "\t　 U￣U￣￣￣U￣￣U");

														System.out.println("\t날죽이다니..\n");
														변수 = false;
														continue;
													} // if 종료

													if (hp <= 0) {
														System.out.println("\t사망했습니다 마을로 돌아가자");
														exp -= 2;
														gold -= 1;

														마을 = false;
														break;
													}

													if (몬스터C <= 0) {
														exp += 2;
														gold += 3;
														
														System.out.println("\t경험치 " + exp + " 획득\n골드 " + gold + " 획득");
														System.out.println("\t．．．．．/)─―ヘ\r\n" + "\t　　　━／　　　　＼\r\n"
																+ "\t ／　　　　●　　●丶\r\n" + "\t　｜　　　　　　　▼　| \r\n"
																+ "\t　｜　　　　　　　亠ノ 　\r\n" + "\t　 U￣U￣￣￣U￣￣U");

														System.out.println("\t날죽이다니..\n");
														break;
													}

													continue; // 전투를 계속할지 말지 선택할 수 있도록

												} // battle 1번 공격하기 if 종료

												else if (battle == 2) { // 2번 스킬사용 선택

													if (전직확인 == 1) {

														몬스터B -= 전사스킬;
														ran = (int) ((Math.random() * 4) + 1);
														hp -= ran;
														System.out.println("\t검휘두르기 데미지 : " + 전사스킬);
														System.out.println("\t몬스터가 가한 피해 : " + ran);
														System.out.println("\t내 체력 " + hp);
														System.out.println("\t몬스터A 체력 " + 몬스터B);

														if (hp <= 0) {
															System.out.println("\t사망했습니다 마을로 돌아가자");
															exp -= 2;
															gold -= 1;

															마을 = false;
															break;
														}

														if (몬스터B <= 0) {
															exp += 2;
															gold += 3;
															
															System.out.println("\t경험치 " + exp + " 획득\n골드 " + gold + " 획득");
															System.out.println("\t．．．．．/)─―ヘ\r\n" + "\t　　　━／　　　　＼\r\n"
																	+ "\t ／　　　　●　　●丶\r\n" + "\t　｜　　　　　　　▼　| \r\n"
																	+ "\t　｜　　　　　　　亠ノ 　\r\n" + "\t　 U￣U￣￣￣U￣￣U");

															System.out.println("\t날죽이다니..\n");
															break;
														}

													}

													if (전직확인 == 2) {

														몬스터B -= 마법사스킬;
														ran = (int) ((Math.random() * 4) + 1);
														hp -= ran;

														System.out.println("\t파이어볼 데미지 : " + 마법사스킬);
														System.out.println("\t몬스터가 가한 피해 : " + ran);
														System.out.println("\t내 체력 " + hp);
														System.out.println("\t몬스터A 체력 " + 몬스터B);

														if (hp <= 0) {
															System.out.println("\t사망했습니다 마을로 돌아가자");
															exp -= 2;
															gold -= 1;

															마을 = false;
															break;
														}

														if (몬스터B <= 0) {
															exp += 2;
															gold += 3;
															
															System.out.println("\t경험치 " + exp + " 획득\n골드 " + gold + " 획득");
															System.out.println("\t．．．．．/)─―ヘ\r\n" + "\t　　　━／　　　　＼\r\n"
																	+ "\t ／　　　　●　　●丶\r\n" + "\t　｜　　　　　　　▼　| \r\n"
																	+ "\t　｜　　　　　　　亠ノ 　\r\n" + "\t　 U￣U￣￣￣U￣￣U");

															System.out.println("\t날죽이다니..\n");
															break;
														}
													}

													if (전직확인 == 3) {

														몬스터B -= 궁수스킬;
														ran = (int) ((Math.random() * 4) + 1);
														hp -= ran;

														System.out.println("\t활쏘기 데미지 : " + 궁수스킬);
														System.out.println("\t몬스터가 가한 피해 : " + ran);
														System.out.println("\t내 체력 " + hp);
														System.out.println("\t몬스터A 체력 " + 몬스터B);

														if (hp <= 0) {
															System.out.println("\t사망했습니다 마을로 돌아가자");
															exp -= 2;
															gold -= 1;

															마을 = false;
															break;
														}

														if (몬스터B <= 0) {
															exp += 2;
															gold += 3;
															
															System.out.println("\t경험치 " + exp + " 획득\n골드 " + gold + " 획득");
															System.out.println("\t．．．．．/)─―ヘ\r\n" + "\t　　　━／　　　　＼\r\n"
																	+ "\t ／　　　　●　　●丶\r\n" + "\t　｜　　　　　　　▼　| \r\n"
																	+ "\t　｜　　　　　　　亠ノ 　\r\n" + "\t　 U￣U￣￣￣U￣￣U");

															System.out.println("\t날죽이다니..\n");
															break;
														}
													}
													
													else {
														System.out.println("\t*｡*.。*∧,,,∧\r\n"
																+ "\t  ヾ(⌒(_=•ω•)_");
														System.out.println("\t스킬은 전직 후 사용가능하다구!");
													}
													

													continue;
												} // battle 2번 스킬사용 else if 종료

												else if (battle == 3) { // 3번 도망가기 선택
													System.out.println("\tᕕ( ˃̣̣̥᷄⌓˂̣̣̥᷅ )ᕗ");
													System.out.println("\t필드로 도망갑니다..!\n");

													break;
												} // battle 3번 도망가기 else if 종료

												else {
													System.out.println("\t다시 선택하세요!");
													continue;
												} // battle else 종료

											} // while

										} // hunt_select 1번 전투 if 종료

										else if (hunt_select == 2) { // 2번 숨어있기 선택
											System.out.println("\t|∧_∧\r\n"
													+ "\t|'ㅅ')\r\n"
													+ "\t|⊂ ノ\r\n"
													+ "\t| \n\t숨어있자!\n");
											continue;

										} // hunt_select 2번 숨어있기 else if 종료

										else if (hunt_select == 3) { // 3번 마을로 돌아가기 선택
											break;

										} // hunt_select 3번 마을로가기 else if 종료c
									} // 전투 while 종료

									// =============================

								} // hunt 3번 else if 종료

								else if (hunt == 4) { // 4번 마을 선택
									System.out.println("");

									break;

								} // hunt 4번 else if 종료

							} // 던전 if While E

						} // 던전 선택 if E
						// ------------ 던전 입장 시 종료 ----------- //

						///////////////////////////////////////////////////////////// 마을선택/////////////////////////////////////////////////////////
						else if (home == 2) {
							System.out.println("상점에 입장하셨습니다");
							System.out.println("　　　　　　　　　| \r\n" + "　　　　　　　　　| \r\n" + "　　　　　 　　　 ﾉ,,∧ \r\n"
									+ "　　　　　　　 ／/･ω･`) \r\n" + "　　　　　　／　/⊂ノ \r\n" + " 　　　　　　＼ /ーJ \r\n" + " ￣￣￣￣￣￣￣");
							System.out.println("어서오세옹 무엇을 원하는냐옹\n 1.물약구입");
							int buy = scanner.nextInt();

							if (buy == 1) {
								System.out.println("\t👉 사용 골드는:" + gold-- + "💪(■_■💪)\r\n" + "      \t🤞맛나게 드시게나🤞");
							} // 물약구입 if E

						} // 상점 구매 else if E

						else if (home == 3) { // 휴식

						}

						else if (home == 4) { // 상태창

							캐릭터정보 = "👉성별 : " + x + "\n👉아이디: " + name + "\n👉HP : " + hp + "\n👉MP : " + mp
									+ "\n👉경험치 : " + exp + "\n👉골드 : " + gold + "\n👉직업 : " + 전직;

							System.out.println(캐릭터정보);
						} else {
							System.out.println("번호재선택");
						}

						System.out.println("▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀");
						System.out.println("\t마을로 돌아왔습니다");
						continue;
					} // 마을 While E

				} // 마을 if E

			} // 1번 선택시 if E
//   if(answer==1) {}   
			// else if(answer==2) {}

			else if (input == 2) {

			} else if (input == 3) {
			} else {
				System.out.println("리스트에서 골라주세요");

			}

///////////////////////////////////////////////////////////////////////////////////////////////////////   

		} // while E
	}// main E
}// class E