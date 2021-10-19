package Uebung2.control;

public class CreatMember implements Member {

    private Integer ID ;

    public CreatMember(Integer ID){
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
