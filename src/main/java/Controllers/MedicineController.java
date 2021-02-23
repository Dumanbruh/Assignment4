package Controllers;

import Entities.Medicine;
import Repository.MedicineRepositoryInterface;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("medicine")
public class MedicineController {
    @Inject
    private MedicineRepositoryInterface medicineRepositoryInterface;

    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findbyname(@PathParam("name") String name) {
        List<Medicine> medicineList;
        try {
            medicineList = medicineRepositoryInterface.findbyname(name);
        } catch (ServerErrorException ex) {
            return Response
                    .status(500).entity(ex.getMessage()).build();
        }

        if (medicineList == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Medicine NOT FOUND!")
                    .build();
        }
        return Response.status(Response.Status.OK)
                .entity(medicineList)
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createMedicine(Medicine medicine) {
        boolean created;
        try {
            created = medicineRepositoryInterface.addMedicine(medicine);
        } catch (ServerErrorException ex) {
            return Response.serverError().entity(ex.getMessage()).build();
        }

        if (!created) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("User cannot be created!")
                    .build();
        }

        return Response
                .status(Response.Status.CREATED)
                .entity("User created successfully!")
                .build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMedicineId(@PathParam("id") int id) {
        Medicine medicine;
        try {
            medicine = medicineRepositoryInterface.getMedicineId(id);
        } catch (ServerErrorException ex) {
            return Response
                    .status(500).entity(ex.getMessage()).build();
        }

        if (medicine == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("User does not exist!")
                    .build();
        }

        return Response
                .status(Response.Status.OK)
                .entity(medicine)
                .build();
    }



    @GET
    @Path("/{weight}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMedicineWeight (@PathParam("weight") int weight) {
        Medicine medicine;
        try {
            medicine = medicineRepositoryInterface.getMedicineWeight(weight);
        } catch (ServerErrorException ex) {
            return Response
                    .status(500).entity(ex.getMessage()).build();
        }

        if (medicine == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("User does not exist!")
                    .build();
        }

        return Response
                .status(Response.Status.OK)
                .entity(medicine)
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeMedicine(int id) {
        boolean removed;
        try {
            removed = medicineRepositoryInterface.removeMedicine(id);
        } catch (ServerErrorException ex) {
            return Response.serverError().entity(ex.getMessage()).build();
        }

        if (!removed) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("User cannot be created!")
                    .build();
        }

        return Response
                .status(Response.Status.NO_CONTENT)
                .entity("User removed successfully!")
                .build();
    }


}