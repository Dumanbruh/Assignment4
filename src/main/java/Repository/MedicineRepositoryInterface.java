package Repository;

import Entities.Medicine;
import java.util.List;

public interface MedicineRepositoryInterface {
    List<Medicine> findbyname(String name);
    Medicine getMedicineId(int id);
    boolean addMedicine(Medicine medicine);
    boolean removeMedicine(int id);
    Medicine getMedicineWeight(int weight);
}
