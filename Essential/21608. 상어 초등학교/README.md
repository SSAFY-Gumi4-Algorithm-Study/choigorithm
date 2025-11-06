## 문제 이해

* N×N 교실의 빈 좌석에 학생들을 **순서대로** 앉힌다.
* 각 학생은 좋아하는 4명의 친구가 있고, 좌석 배치는 아래 우선순위를 따른다:
  1. 인접 4칸에 **좋아하는 학생이 가장 많은** 자리
  2. 위 조건이 같다면 **인접 빈칸이 많은** 자리
  3. 그래도 같다면 **행 번호가 작은** 자리
  4. 그래도 같다면 **열 번호가 작은** 자리
* 모든 학생을 배치한 후 만족도를 계산:  
  * 인접 4칸의 좋아하는 학생 수에 따른 점수 = {0, 1, 10, 100, 1000}

## 구현 흐름

1. **입력**  
   * 학생 배치 순서 `students[]`
   * `preferences`: 각 학생 → 좋아하는 학생 4명(`Set<Integer>`)
   * `seats`: 교실 좌석 상태 (N×N)

2. **배치**  
   * `findSeat(student)`에서 모든 빈칸을 검사해 우선순위에 가장 맞는 좌석을 선택
   * 선택된 좌석에 학생을 앉힘

3. **출력**  
   * `calcSum()`으로 최종 만족도 합을 계산해 출력

## 클래스/함수별 역할
### `Seat`
* 좌석 위치: `r`,`c`
* 인접 좋아하는 친구 수: `prefer`
* 인접 빈칸 수: `empty`
* 정렬(우선순위)을 **compareTo**로 표현:
  ```java
  if (prefer != other.prefer)
      return Integer.compare(other.prefer, prefer);
  if (empty != other.empty)
      return Integer.compare(other.empty, empty);
  if (r != other.r)
      return Integer.compare(r, other.r);
  return Integer.compare(c, other.c);
  ```

### `findSeat(int student)`
* 모든 빈칸을 순회하며 `Seat(i,j, prefer, empty)`를 계산
* `Comparable` 기준으로 **가장 우선순위 높은 좌석**을 선택해 착석

### `findPrefer(int student, int r, int c)`
* (r,c) 4방향을 확인하여, 그 칸에 앉아있는 학생이 `student`가 좋아하는 학생이면 카운트

### `findEmpty(int r, int c)`
* (r,c) 4방의 **빈칸(=0)** 개수 카운트

### `calcSum()`
* 모든 칸에 대해 `findPrefer(seats[i][j], i, j)`를 다시 구해 점수로 환산 후 누적

## 복잡도
* 각 학생에 대해 N²개의 빈칸을 검사, 빈칸당 4방 확인(상수)
  → 전체 약 **O(N⁴)** (N ≤ 20이라서 통과)

