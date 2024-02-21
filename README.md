# java-ladder

사다리 타기 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

## 요구사항
- 게임 참여하는 사람에 이름 최대 5글자
- 사다리 출력시 이름도 같이
- 이름 쉼표 구분
- 이름이 5자 기준으로 출력되기 때문에, 사다리 폭도 넓어져야함
- 정상동작하려면 라인이 겹치치 않아야 함
|-----|-----| <- 가로 라인이 겹치면 어디로 갈지 모름

- Player
  - 이름 5글자 이하
- Height - 사다리 높이
  - 10 이하
- Ladder = List<Line>
  - Line(두 플레이어를 포함)
  - width (Players 수)
- Bridge - 위치, 상태


- 
인원 입력.
```
인원 입력. (쉼표 구분)
a1,a2,a3

최대 사다리 높이는?
5

결과

   a1    a2    a3
    |-----|     |
    |     |-----|
    |-----|     |
```
