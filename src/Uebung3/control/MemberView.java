package Uebung3.control;

import Uebung3.control.Member;

import java.util.List;

public class MemberView {


    public void dump( List<Member> liste ){
        for (Member member : liste){
            System.out.println(member.toString());
        }
    }
}
