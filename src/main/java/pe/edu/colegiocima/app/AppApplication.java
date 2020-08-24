package pe.edu.colegiocima.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.edu.colegiocima.app.models.dao.CargaHorariaDAO;
import pe.edu.colegiocima.app.models.dao.GradoDAO;
import pe.edu.colegiocima.app.models.dao.PlanEstudioDAO;
import pe.edu.colegiocima.app.models.entity.PlanEstudio;
import pe.edu.colegiocima.app.models.repository.AnioLectivoRepository;
import pe.edu.colegiocima.app.models.repository.AreaAsignaturaRepository;
import pe.edu.colegiocima.app.models.repository.AsignaturaRepository;
import pe.edu.colegiocima.app.models.repository.GradoRepository;

import java.util.List;

@SpringBootApplication
public class AppApplication
     // implements CommandLineRunner
{

    @Autowired
    private GradoRepository gradoRepository;
    @Autowired
    private AnioLectivoRepository anioLectivoRepository;    
    @Autowired
    private AreaAsignaturaRepository aaRepository;
    @Autowired
    private AsignaturaRepository asignaturaRepository;    
    @Autowired
    private GradoDAO gradoDAO;
    @Autowired
    private CargaHorariaDAO cargaHorariaDAO;
    @Autowired
    private PlanEstudioDAO planEstudioDAO;
    
    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }

    //@Override
    public void run(String ... args) throws Exception {
        List<PlanEstudio> lista=planEstudioDAO.busquedaPersonalizada((short)52, (short)5);
        for (PlanEstudio o : lista) {
            System.out.println("ID: "+o.getId());
            System.out.println("Area Curricular: "+o.getAreaAsignatura().getAreaCurricular().getDescripcion());
            System.out.println("Asignatura: "+o.getAreaAsignatura().getAsignatura().getDescripcion());            
        }
        /*List<CargaHorariaUDT> lista = Arrays.asList(
          new CargaHorariaUDT((short)4154, (short)905),
          new CargaHorariaUDT((short)3822, (short)902),
          new CargaHorariaUDT((short)1078, (short)906),
          new CargaHorariaUDT((short)551, (short)907),
          new CargaHorariaUDT((short)982, (short)908)
        );
        CargaHorariaUDT[] array = new CargaHorariaUDT[lista.size()];
        array = lista.toArray(array);
        Integer respuesta=cargaHorariaDAO.generar((short)1, (short)4622,array,(short)5744);
        System.out.println("Respuesta: "+respuesta);*/
        /*int size=5;
        Short[] idDocente={4155,3821,1077,550,981};
        Short[] idGradoSeccion={905,902,906,907,908};
        Integer respuesta=cargaHorariaDAO.generar((short)1, (short)4622, idDocente, idGradoSeccion,(short)5744, size);
        System.out.println("Respuesta: "+respuesta);*/
        /*List<String> lista =Arrays.asList("LUIS","BACA","ALEX","DAVID","PIO","BRAYAN");
         for (String nombre : lista) {
             if(Objects.equals(nombre, "BACA")){
                    continue;
             }             
             System.out.println("Hola");
             System.out.println(nombre);
             System.out.println("a codear");
         }*/
        /*List<AreaAsignaturaVista> lista = aaRepository.findCustom();
        for (AreaAsignaturaVista o : lista) {
            System.out.println("-------------------------");
            System.out.println("ID: "+o.getId());
            System.out.println("Descripcion: "+o.getDescripcion());
            System.out.println("Area Curricular : "+o.getAreaCurricular());
            System.out.println("Asignatura: "+o.getAsignatura());
        }*/
        /*List<AreaAsignaturaCustom> lista =aaRepository.findByOrderByAreaCurricularDescripcion();
        for (AreaAsignaturaCustom o : lista) {
            System.out.println("-------------------------");
            System.out.println("ID: "+o.getId());
            System.out.println("Area Curricular: "+o.getAreaCurricular().getDescripcion());
            System.out.println("Asignatura: "+o.getAsignatura().getDescripcion());
        }
        */
       // Iterable<AreaAsignatura> listaAA=aaRepository.findAll();
        /*Asignatura asignatura=asignaturaRepository.findById((short)88).orElse(null);
       List<AreaAsignatura> listaAA=asignatura.getAreasAsignatura();
        for (AreaAsignatura aa : listaAA) {
            System.out.println("ID "+aa.getId());
            AreaCurricular ac=Objects.nonNull(aa.getAreaCurricular())? aa.getAreaCurricular(): new AreaCurricular();
            System.out.println("Area Curricular "+ac.getDescripcion());
        }*/        
        /*Calendar calendar =new GregorianCalendar(2008,0,1);
        List<Object[]> lista=gradoRepository.buscarIdNivelGrado(calendar.getTime());
        lista.forEach((o) -> System.out.println("ID Colegio: "+o[0]+" ID Grado: "+o[1])); */
        
        // List<AnioLectivo> lista =anioLectivoRepository.buscarPorACtivo();
        // List<AnioLectivo> lista =anioLectivoRepository.findByActivoTrueOrderById();
        // List<AnioLectivoVista> lista =anioLectivoRepository.findByActivoTrueOrderById();
        /*for (AnioLectivoVista a : lista) {
        System.out.println("ID: "+a.getId()+" Descripcion: "+a.getDescripcion());
        }*/
        // List<AnioLectivoDTO> lista =anioLectivoRepository.findByActivoTrueOrderByDescripcion();
        /*List<AnioLectivoDTO> lista =anioLectivoRepository.busquedaActivo();
        for (AnioLectivoDTO a : lista) {
        System.out.println("ID: "+a.getId()+" Descripcion: "+a.getDescripcion());
        }*/        
        /*Grado g = gradoRepository.findByDescripcionAndIdNivelColegio("GRADO2",1);
        if (Objects.isNull(g)){
        //Short r1 =gradoRepository.insertar("G1",(short)1,(short)26,12,true);
        Short r2 =gradoRepository.queryInsertarDML("GRADO1",(short)1,(short)26,12,true);
        System.out.println("ID: "+r2);
        }*/
        /*
        Grado g = gradoRepository.findByDescripcionAndIdNivelColegio(grado.getDescripcion(),grado.getIdNivelColegio());
        if(Objects.isNull(g)) {
        Short r3 = gradoDAO.insertar(grado);
        System.out.println(r3);
        }*/
        /*
        Boolean r4 =gradoRepository.editar("G1",(short)1,(short)26,12,true,(short)121);
        System.out.println(r4);
         */
        /*Grado grado = new Grado();
        grado.setId(121L);
        grado.setDescripcion("GCIMA3");
        grado.setIdNivelColegio(1);
        grado.setIdGradoAnterior(26);
        grado.setEdad(12);
        grado.setCirculoEstudio(true);
        Boolean r5 =gradoDAO.editar(grado);
        System.out.println(r5);
         */
        /*AnioLectivo anioLectivo = new AnioLectivo();
        anioLectivo.get*/
    }
}
