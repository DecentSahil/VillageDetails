package Village.Details;
class ServiceRequest {
    protected String type;
    protected String priority;
    protected int villagersAffected;

    public void createRequest() {
        System.out.println("Generic service request created.");
    }

    public void createRequest(String type) {
        this.type = type;
        System.out.println("Request created for: " + type);
    }

    public void createRequest(String type, String priority) {
        this.type = type;
        this.priority = priority;
        System.out.println("Request created for: " + type + " with priority: " + priority);
    }

    public void createRequest(String type, String priority, int villagersAffected) {
        this.type = type;
        this.priority = priority;
        this.villagersAffected = villagersAffected;
        System.out.println("Request for " + type + " with priority " + priority +
                ", affecting " + villagersAffected + " villagers.");
    }
}

class WaterRequest extends ServiceRequest {
    @Override
    public void createRequest() {
        System.out.println("Water service request: Issue reported to water department.");
    }

    @Override
    public void createRequest(String type) {
        super.createRequest(type);
        System.out.println("Water Request logged: " + type);
    }

    @Override
    public void createRequest(String type, String priority) {
        super.createRequest(type, priority);
        System.out.println("Water Request priority set to: " + priority);
    }

    @Override
    public void createRequest(String type, String priority, int villagersAffected) {
        super.createRequest(type, priority, villagersAffected);
        System.out.println("Water Request handled for " + villagersAffected + " villagers.");
    }
}

class ElectricityRequest extends ServiceRequest {
    @Override
    public void createRequest() {
        System.out.println("Electricity service request: Notified electricity board.");
    }

    @Override
    public void createRequest(String type) {
        super.createRequest(type);
        System.out.println("Electricity Request logged: " + type);
    }

    @Override
    public void createRequest(String type, String priority) {
        super.createRequest(type, priority);
        System.out.println("Electricity Request priority: " + priority);
    }

    @Override
    public void createRequest(String type, String priority, int villagersAffected) {
        super.createRequest(type, priority, villagersAffected);
        System.out.println("Electricity Request affecting " + villagersAffected + " people.");
    }
}

class MedicalRequest extends ServiceRequest {
    @Override
    public void createRequest() {
        System.out.println("Medical service request: Contact local health center.");
    }

    @Override
    public void createRequest(String type) {
        super.createRequest(type);
        System.out.println("Medical Request issue: " + type);
    }

    @Override
    public void createRequest(String type, String priority) {
        super.createRequest(type, priority);
        System.out.println("Medical Request with priority: " + priority);
    }

    @Override
    public void createRequest(String type, String priority, int villagersAffected) {
        super.createRequest(type, priority, villagersAffected);
        System.out.println("Medical Request requires care for " + villagersAffected + " villagers.");
    }
}


class VillageAdmin {
    public void processRequest(ServiceRequest req) {
        System.out.println("Village Admin processing request...");
        req.createRequest();  // Dynamic dispatch
    }
}

public class Main {
    public static void main(String[] args) {
        WaterRequest water = new WaterRequest();
        ServiceRequest electricity = new ElectricityRequest();
        ServiceRequest medical = new MedicalRequest();

        water.createRequest("Pipeline Burst", "High", 80);
        electricity.createRequest("Transformer Failure", "Medium", 120);
        medical.createRequest("Flu Outbreak", "Critical", 60);

        VillageAdmin admin = new VillageAdmin();
        System.out.println();
        admin.processRequest(water);
        admin.processRequest(electricity);
        admin.processRequest(medical);
    }
}
