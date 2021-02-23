import Database.Database;
import Database.IDB;
import Repository.MedicineRepository;
import org.glassfish.jersey.internal.inject.AbstractBinder;

public class MyApplicationBinder extends AbstractBinder {

    @Override
    protected void configure() {
        bind(Database.class).to(IDB.class);
        bind(MedicineRepository.class).to(MedicineRepository.class);
    }
}