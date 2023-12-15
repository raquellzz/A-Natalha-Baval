module br.ufrn.imd {
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    opens br.ufrn.imd to javafx.fxml;

    exports br.ufrn.imd;
    exports br.ufrn.imd.controller;
    exports br.ufrn.imd.model;

}
