package com.example.b01.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class PageResponseDTO<E> {

    private int page;  //필드 선언
    private int size;   //필드 선언
    private int total;   //필드 선언

    private int start;    //필드 선언
    private int end;       //필드 선언

    private boolean prev;    //필드 선언
    private boolean next;   //필드 선언

    private List<E> dtoList;  //List는 java의 상위 클래스 필드 선언

    @Builder(builderMethodName = "withAll")
    public PageResponseDTO(PageRequestDTO pageRequestDTO,List<E> dtoList, int total){

        if(total <= 0) {
            return;
        }

        this.page = pageRequestDTO.getPage();
        this.size = pageRequestDTO.getSize();
        this.total = total;
        this.dtoList = dtoList;

        this.end = (int)(Math.ceil(this.page / 10.0)) * 10;
        this.start = this.end - 9; //end 사이즈가 10이면 첫번째 시작 페이지 1이 된다.
        //화면에는 항상 10페지만 출력됩니다.
        int last = (int)(Math.ceil((total/(double)size)));

        this.end = end > last ? last : end;
        this.prev = this.start > 1;
        this.next = total > this.end * this.size;



    }



}
