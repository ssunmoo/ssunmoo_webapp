package study.s2;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Scanner;

public class test3 {

	public static void main(String[] args) {
		System.out.println(" >> Level3_3 answer >> ");
		System.out.println(" >> answer time : " + LocalDateTime.now() + " >> \n");
		Scanner scanner = new Scanner(System.in);

		/* 문제풀이 위치 */
		String[] friendlist = new String[3]; // 3개까지 저장가능한 고정된 배열

		System.out.print("친구목록 수 ");
		int friendNum = scanner.nextInt();
		System.out.println();

		for (int i = 0; i < friendlist.length; i++) { // i는 0부터 friendlist까지 ++
			System.out.print(i + 1 + " 번째 친구명 : "); // 인덱스가 0부터 시작이니까 +1을 더하여 출력
			friendlist[i] = scanner.next();
			System.out.println("i : " + friendlist[i]);

			if (i >= 1) {
				if (friendlist[i].equals(friendlist[i-1])) {
					System.out.println("중복입니다 다시쓰세오");
					// System.out.println("i:" + friendlist[i]); // 잘들어가는지 확인용
					// System.out.println("i-1:" + friendlist[i-1]); // 잘들어가는지 확인용
					i--;
					continue;
				}
			}
			System.out.println(Arrays.toString(friendlist)); // 배열에 들어가는거 확인용!
		}

	}
}

/*
 * [문제] Level3_1 이어서 작성합니다. 1차원 배열에 저장된 모든 요소들을 순서대로 출력합니다. [조건] 1. 문제풀이 위치 외
 * 코드는 수정 불가 합니다. 2. 만일 배열에 null 존재할경우 출력하지 않습니다.
 */

/* ----------- */

/*
 * [문제] Level3_2 이어서 작성합니다. 중복체크를 진행합니다. [조건] 1. 문제풀이 위치 외 코드는 수정 불가 합니다. 2. 만일
 * 배열에 null 존재할경우 출력하지 않습니다. 3. [ 중복체크 ] 입력한 데이터가 이미 배열에 존재할 경우 다시 입력받습니다.
 */
