package sprint4.mks;

class Zvezda extends Zarya {

    public Zvezda() { // доступ к изменению конструктора запрещён
        super();
        energyConsumption = 44;
        activateModule();
    }
    // доступ к созданию новых конструкторов запрещён

    // разрешено переопределение методов

    @Override
    void activateModule() {
        super.activateModule();
        turnSolarPanels();
    }
}
