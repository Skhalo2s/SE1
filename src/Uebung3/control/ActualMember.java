package Uebung3.control;
/**
 *
 * @author Salah Khalosi
 * @fachbereich_kuerzel skhalo2s
 * @vision 1.0
 *
 */

public class ActualMember implements Member {

    private Integer ID ;

    public ActualMember(Integer ID){
        this.ID = ID;
    }

    @Override
    public Integer getID() {
        return ID;
    }

    @Override
    public String toString(){
        return "Member (ID = " + ID +" )";
    }
}
