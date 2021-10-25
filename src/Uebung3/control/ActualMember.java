package Uebung3.control;

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
