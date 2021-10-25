package Uebung3.control;

import java.util.List;
/**
 *
 * @author Salah Khalosi
 * @fachbereich_kuerzel skhalo2s
 * @vision 1.0
 *
 */

public class MemberView {


    public void dump( List<Member> liste ){
        for (Member member : liste){
            System.out.println(member.toString());
        }
    }
}
