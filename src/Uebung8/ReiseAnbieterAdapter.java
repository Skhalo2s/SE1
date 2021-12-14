package Uebung8;

public class ReiseAnbieterAdapter {

    public QueryResult  executeQuery (  QueryObject q ) {
        return new QueryResult();
    }

    private QueryObject transformationIn(   SuchAuftrag s) {
        return new QueryObject();
    }


    private SuchErgebnis TransformationOut(  QueryResult  q) {
        return new SuchErgebnis();
    }
}
