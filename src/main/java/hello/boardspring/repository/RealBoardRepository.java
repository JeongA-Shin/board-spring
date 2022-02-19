package hello.boardspring.repository;

import hello.boardspring.domain.Board;

import java.util.*;

public class RealBoardRepository implements BoardRepository{
   
    private static Map<Long,Board> store=new HashMap<>();//Map<키, 값>
    private static long sequence=0L; //idx 값으로 들어가는 것
    
    @Override
    public Board save(Board board) {
        board.setIdx(++sequence);//idx는 1번부터 시작  //우선 idx set.(idx값 설정)
        store.put(board.getIdx(),board); //해당 idx 값과 board객체를 store(Baord (도메인객체)가 저장되는 곳)에 저장
        return board;
    }
    
    @Override
    public Optional<Board> findByIdx(Long idx) {
        //해당 idx가 없으면 null 객체가 반환됨. 즉 null객체가 반환될 가능성이 있으므로 옵셔널로 감쌈
        //이래야 클라이언트 쪽에서 따로 어떤 처리가 가능해짐
        return Optional.ofNullable(store.get(idx));
        //Board(도메인 객체)가 저장된 store에서 해당되는 idx(키) 값을 가진 것을 조회.Borad 객체 나옴
    }
    
    @Override
    public Optional<Board> findByTitle(String title) {
        
        return store.values().stream() // Map 요소들 각각을 .filter내의 람다식(익명 함수, 화살표 함수)으로 필요한 요소들만 걸러내는 등 제어할 수 있도록 stream화 해줌
                       .filter(board->board.getTitle().equals(title)) //filter 는 요소를 특정 기준으로 걸러낼 수 있습니다.//js의 화살표 함수처럼 조건을 닮
                       .findAny(); //findAny()는 Stream에서 가장 먼저 탐색되는 요소를 리턴
    }
    
    @Override
    public List<Board> findAll() {
        //어차피 지금 리포지토리, 즉 Map인 store에 저장되어 있는 모든 Board 객체들(즉 모든 value들)을 반환하면 됨
        //즉 Map인 store 를 걍 통채로 반환하면 됨. 근데 지금 함수의 반환형이 List임
        //따라서 List로 자료형을 바꾸어서 반환해주면 됨
        return new ArrayList<>(store.values()) ;//ArrayList는 자바의 List 인터페이스를 상속받은 여러 클래스 중 하나입니다.
        //배열과의 차이점은 배열이 크기가 고정인 반면 ArrayList는 크기가 가변적으로 변합니다.
    }
    
    public void clearStore(){
        store.clear();
    }
}
