package Uebung3.view;

import Uebung3.control.Container;
import Uebung3.control.ActualMember;
import Uebung3.control.MemberView;
import Uebung3.control.exceptions.ContainerException;
/**
 *
 * @author Salah Khalosi
 * @fachbereich_kuerzel skhalo2s
 * @vision 1.0
 *
 */

public class Client {

    public void startClient(){
        Container myContainer = Container.getInstanc();
        try {
            myContainer.addMember(new ActualMember(1));
            myContainer.addMember(new ActualMember(2));
            myContainer.addMember(new ActualMember(3));
        } catch (ContainerException e) {
            e.printStackTrace();
        }

        MemberView newView = new MemberView();
        newView.dump(myContainer.getCurrentList());
    }

}
