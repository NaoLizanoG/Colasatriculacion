import java.util.LinkedList;
import java.util.Queue;

public class ColaMatricula {
    private Queue<Carro> carros;



    public ColaMatricula() {
        carros = new LinkedList<Carro>();
    }

    public void encolar(String propietario, String marca, int anio){
        carros.add(new Carro(propietario, marca, anio));
    }
    public  Carro desencolar() throws Exception {//el throws obliga a quien use este metodoa manejar la excepcion
        if (carros.isEmpty())
            throw new Exception("No hay vehiculos en la cola");
        return carros.poll();
    }



    public String listarVehiculos(){
        String mensaje="";
        for(Carro v:carros){
            mensaje+=v.toString();
        }
        return mensaje;
    }

    public String listarVehiculoMarca(String marca){
        String mensaje="";
        for(Carro v:carros){//for que recorre la cola
            if(v.getMarca().equals(marca)){
                mensaje+=v.toString();
            }
        }
        return mensaje;
    }
}
