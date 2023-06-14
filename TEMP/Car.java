// 강한 결합 (Tight Coupling)

public class Car{

    // private GasolineEngine gasolineEngine = new GasolineEngine();
    private ElectricEngine electricEngine = new ElectricEngine();

    public void ride(){
        // gasolineEngine.useOil();
        electricEngine.useSource();
    }
}

public class ElectricEngine{
    public void useBettery(){

    }
}

public class GasolineEngine{

    public void useOil(){

    }
}



public interface PowerUnit{
    void useSource();
}

public class GasolineEngine implements PowerUnit{
    @Override
    public void useSource(){가솔린 엔진 운영}
}

public class ElectricEngine implements PowerUnit{
    @Override
    public void useSource(){전기 엔진 운영}
}

DI (Dependency Injection) --> 종속성 주입