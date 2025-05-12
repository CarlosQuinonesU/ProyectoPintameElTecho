/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.pintameeltecho.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import ucr.ac.cr.pintameeltecho.controller.serviceController.ServiceController;
import ucr.ac.cr.pintameeltecho.controller.userController.UserController;
import ucr.ac.cr.pintameeltecho.model.review.Review;
import ucr.ac.cr.pintameeltecho.model.review.ReviewList;
import ucr.ac.cr.pintameeltecho.model.review.ReviewRecord;
import ucr.ac.cr.pintameeltecho.model.service.Service;
import ucr.ac.cr.pintameeltecho.model.service.ServiceRecord;
import ucr.ac.cr.pintameeltecho.model.user.RegularUser;
import ucr.ac.cr.pintameeltecho.model.user.UserRecord;
import ucr.ac.cr.pintameeltecho.view.GUIMain;
import ucr.ac.cr.pintameeltecho.view.page.GUIInfoService;
import ucr.ac.cr.pintameeltecho.view.service.GUIReview;
import ucr.ac.cr.pintameeltecho.view.page.MainPage;
import ucr.ac.cr.pintameeltecho.view.service.ServiceTable;
import ucr.ac.cr.pintameeltecho.view.user.GUIRegistration;
import ucr.ac.cr.pintameeltecho.view.service.GUIServiceRegister;
import ucr.ac.cr.pintameeltecho.view.user.GUIUserMaintenance;

/**
 *
 * @author Admin
 */
public class MainController implements ActionListener, MouseListener, KeyListener {

    private GUIMain guiMain;
    private GUIRegistration guiRegistration;
    private UserController userController;
    private ServiceController serviceController;
    private GUIServiceRegister guiServiceRegister;
    private UserRecord userRecord;
    private RegularUser user;
    private GUIUserMaintenance guiUserMaintenance;
    private MainPage mainPage;
    private ServiceTable serviceTable;
    private ServiceRecord record;
    private Service service;
    private GUIInfoService guiInfoService;
    private GUIReview guiReview;
    private ReviewRecord reviewRecord;

    private int star;

    public MainController() {
        guiMain = new GUIMain();
        mainPage = new MainPage();
        serviceController = new ServiceController(this);
        userController = new UserController(this);
        guiReview = new GUIReview();
        record = serviceController.getRecord();
        userRecord = userController.getUserRegister();
        reviewRecord = new ReviewRecord();
        guiUserMaintenance = userController.getGuiUserMaintenance();
        serviceTable = mainPage.getServiceTable();
        guiInfoService = new GUIInfoService(mainPage, true);
        guiRegistration = new GUIRegistration();
        guiMain.listen(this);
        guiMain.setVisible(true);
        mainPage.listen(this);
        guiInfoService.listen(this);
        guiReview.listen(this);
        guiReview.listenMouse(this);
        serviceController.setMainPage(mainPage);
        serviceController.setServiceTable(serviceTable);
        userController.setGuiMain(guiMain);
        serviceTable.listenKey(this);
        serviceTable.listenMouse(this);
        serviceTable.setData(record.getData(), Service.LABELS_SERVICE);
        user = null;
        star = 0;
    }

    public GUIMain getGuiMain() {
        return guiMain;
    }

    public MainPage getMainPage() {
        return mainPage;
    }

    public ServiceTable getServiceTable() {
        return serviceTable;
    }

    public RegularUser getUser() {
        return user;
    }

    public String validate() {
        String datos = "";

        if (guiMain.getTxtLogInUser().equals("")) {
            datos = "El campo del correo electrónico no puede quedar vacío.";
        } else if (guiMain.getTxtLogInPassw().equals("")) {
            datos = "El campo de la contraseña no puede quedar vacío.";
        } else {
            user = userRecord.search(guiMain.getTxtLogInUser());
            if (user == null) {
                datos = "El correo electrónico no se encuentra registrado o coincide, por favor verifique que esté correcto.";
            } else if (!user.getPassword().equals(guiMain.getTxtLogInPassw())) {
                datos = "La contraseña no coincide, por favor verificar.";
            } else {
                datos = "Los datos ingresados son correctos, Bienvenido a PINTAME EL TECHO.";
            }
        }
        return datos;
    }

    public void setStars(Object object) {
        String rutaFull = "./src/main/resources/img/ButtonFullStar.png";
        String rutaEmpty = "./src/main/resources/img/ButtonEmptyStar.png";
        if (object == guiReview.getBtnStar5()) {
            guiReview.setBtnStar1(rutaFull);
            guiReview.setBtnStar2(rutaFull);
            guiReview.setBtnStar3(rutaFull);
            guiReview.setBtnStar4(rutaFull);
            guiReview.setBtnStar5(rutaFull);
        } else if (object == guiReview.getBtnStar4()) {
            guiReview.setBtnStar1(rutaFull);
            guiReview.setBtnStar2(rutaFull);
            guiReview.setBtnStar3(rutaFull);
            guiReview.setBtnStar4(rutaFull);
            guiReview.setBtnStar5(rutaEmpty);
        } else if (object == guiReview.getBtnStar3()) {
            guiReview.setBtnStar1(rutaFull);
            guiReview.setBtnStar2(rutaFull);
            guiReview.setBtnStar3(rutaFull);
            guiReview.setBtnStar4(rutaEmpty);
            guiReview.setBtnStar5(rutaEmpty);
        } else if (object == guiReview.getBtnStar2()) {
            guiReview.setBtnStar1(rutaFull);
            guiReview.setBtnStar2(rutaFull);
            guiReview.setBtnStar3(rutaEmpty);
            guiReview.setBtnStar4(rutaEmpty);
            guiReview.setBtnStar5(rutaEmpty);
        } else if (object == guiReview.getBtnStar1()) {
            guiReview.setBtnStar1(rutaFull);
            guiReview.setBtnStar2(rutaEmpty);
            guiReview.setBtnStar3(rutaEmpty);
            guiReview.setBtnStar4(rutaEmpty);
            guiReview.setBtnStar5(rutaEmpty);
        }
    }// Fin de set starts

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Registrarse":
                guiMain.dispose();
                userController.getGuiRegistration().setVisible(true);
                break;
            case "Ingresar":
                String usuarioValido = "Los datos ingresados son correctos, Bienvenido a PINTAME EL TECHO.";
                guiMain.showMessage(validate());
                if (validate().equals(usuarioValido)) {
                    guiMain.dispose();
                    guiMain.clean();
                    if (user.getRol().equals("Usuario")) {
                        mainPage.getBtnMaintenance().setVisible(false);
                        mainPage.getBtnAddService().setVisible(false);
                        mainPage.getBtnDeleteServ().setVisible(false);
                    } else if (user.getRol().equals("Socio")) {
                        mainPage.getBtnMaintenance().setVisible(false);
                        mainPage.getBtnAddService().setVisible(true);
                        mainPage.getBtnDeleteServ().setVisible(false);
                    } else if (user.getRol().equals("admin")) {
                        mainPage.getBtnAddService().setVisible(true);
                        mainPage.getBtnMaintenance().setVisible(true);
                        mainPage.getBtnDeleteServ().setVisible(true);
                    }
                    mainPage.setVisible(true);
                }
                break;
            case "AddService":
                guiMain.dispose();
                serviceController.getGuiServiceRegister().setVisible(true);
                break;
            case "Maintenance":
                String administradorCorrect = "Bienvenido administrador de usuarios.";
                mainPage.dispose();
                guiUserMaintenance.setVisible(true);
                break;
            case "Informacion":
                if (service != null) {
                    guiInfoService.getjLabelTitle().setText(service.getName());
                    guiInfoService.getjLabelDescrip().setText("<html>" + service.getDescription() + "</html>");
                    guiInfoService.getjLabelSocioN().setText(service.getSocio());
                    guiInfoService.setjLabelIcon(service.getIcon());
                    guiInfoService.setjLabelPrice(service.getAproximatePrice());
                    guiInfoService.setStars(service.getCalificacion());
                    guiInfoService.setVisible(true);
                } else {
                    guiMain.showMessage("Debe hacer click en algún servico para poder desplegar más informacón.");
                }
                break;
            case "Hire":
                guiMain.showMessage("Felicidades!\n\nUsted ha contrado el servico, nuestro socio la ha estar realizando el trabajo lo antes posible."
                        + "\nMuchas gracias por preferirnos");
                guiInfoService.dispose();
                guiReview.setVisible(true);
                break;
            case "Guardar":
                if (star == 0) {
                    guiReview.showMessage("Debe asignar una puntuación antes de guardar su review.");
                } else if (guiReview.getTxtReview().equals("")) {
                    guiReview.showMessage("Debe llenar su comentario antes de guardar su review.");
                } else {
                    String listName = service.getName() + " ReviewList";
                    String comment = guiReview.getTxtReview();
                    int reviewStars = star;
                    int starsCalification = 0;
                    ReviewList reviewList = reviewRecord.search(listName);
                    String userName = user.getNameUser();
                    if (reviewRecord.search(listName) == null) {
                        reviewList = new ReviewList(listName);
                        Review review = new Review(reviewStars, comment, userName);
                        reviewList.add(review);
                        reviewRecord.add(reviewList);
                        starsCalification = reviewList.getReview(0).getStars();
                    } else {
                        reviewList = reviewRecord.search(listName);
                        Review review = new Review(reviewStars, comment, userName);
                        reviewList.add(review);
                        reviewRecord.edit(reviewList);
                        for (int index = 0; index < reviewList.getTamaño(); index++) {
                            reviewList = reviewRecord.search(listName);
                            starsCalification += reviewList.getReview(index).getStars();
                        }
                    }

                    service.setCalificacion(starsCalification, reviewList.getTamaño());
                    serviceController.getRecord().edit(service);
                    serviceController.getServiceTable().setData(serviceController.getRecord().getData(), Service.LABELS_SERVICE);
                    star = 0;
                    guiReview.clean();
                    guiReview.dispose();
                    mainPage.setVisible(true);
                }
                break;
            case "Star1":
                star = 1;
                break;
            case "Star2":
                star = 2;
                break;
            case "Star3":
                star = 3;
                break;
            case "Star4":
                star = 4;
                break;
            case "Star5":
                star = 5;
                break;
            case "SalirReview":
                guiReview.clean();
                guiReview.dispose();
                mainPage.setVisible(true);
                break;

            case "Cancel":
                guiInfoService.dispose();
                mainPage.setVisible(true);
                break;

            case "DeleteServ":
                if (service != null) {
                    guiMain.showMessage(record.delete(service.getName()));
                    serviceController.getServiceTable().setData(serviceController.getRecord().getData(), Service.LABELS_SERVICE);
                }
                break;
            case "LogOut":
                mainPage.dispose();
                guiMain.setVisible(true);
                break;
            case "Salir":
                System.exit(0);
                break;
            default:
                throw new AssertionError();
        }// Fin de switch
    }// Fin de accionListener

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

        if (guiReview.isVisible()) {
            Object object = e.getSource();
            setStars(object);
        } else {
            String[] serviceRow = serviceTable.getRowSelected();
            service = record.search(serviceRow[0]);
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {

        Object object = e.getSource();
        if (star == 0) {
            setStars(object);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        String ruta = "./src/main/resources/img/ButtonEmptyStar.png";
        if (star == 0) {
            guiReview.setBtnStar1(ruta);
            guiReview.setBtnStar2(ruta);
            guiReview.setBtnStar3(ruta);
            guiReview.setBtnStar4(ruta);
            guiReview.setBtnStar5(ruta);
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        serviceTable.filterByName();
    }

}// Fin de clase
