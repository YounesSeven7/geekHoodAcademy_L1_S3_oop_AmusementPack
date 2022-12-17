import helper.visitor.AmusementPack;
import model.Visitor;

import java.util.List;

public class Main {

    private static List<Visitor> visitorsList;
    public static void main(String[] args) {
        visitorsList = AmusementPack.getVisitorsList();
    }
}