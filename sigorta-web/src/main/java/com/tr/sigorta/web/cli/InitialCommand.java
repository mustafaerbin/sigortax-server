package com.tr.sigorta.web.cli;

import com.tr.nebula.security.api.domain.PermissionType;
import com.tr.nebula.security.db.domain.Menu;
import com.tr.nebula.security.db.domain.Permission;
import com.tr.nebula.security.db.domain.Role;
import com.tr.nebula.security.db.repository.NebulaMenuRepository;
import com.tr.nebula.security.db.repository.NebulaPermissionRepository;
import com.tr.nebula.security.db.repository.NebulaRoleRepository;
import com.tr.nebula.security.db.repository.NebulaUserRepository;
import com.tr.sigorta.dao.*;
import com.tr.sigorta.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Mustafa Erbin on 16/09/2017.
 */
@Component
public class InitialCommand {

    @Autowired
    private NebulaUserRepository robeUserRepository;

    @Autowired
    private NebulaRoleRepository robeRoleRepository;

    @Autowired
    private NebulaMenuRepository robeMenuRepository;

    @Autowired
    private NebulaPermissionRepository permissionRepository;

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private CompanyProductDao companyProductDao;

    @Autowired
    private CompanyPolicyTypeDao companySubProductDao;

    @Autowired
    private AgencyUserDao agencyUserDao;

    @Autowired
    private AgencyDao agencyDao;

    @Autowired
    private JobControlDao jobControlDao;

    public void run() {

        Role roleGroup = new Role();
        roleGroup.setName("Admin");
        roleGroup.setCode("ADMIN");
        robeRoleRepository.save(roleGroup);

        Role roleGroupAgencyUser = new Role();
        roleGroupAgencyUser.setName("user");
        roleGroupAgencyUser.setCode("AGENCY_USER");
        robeRoleRepository.save(roleGroupAgencyUser);

        Role roleGroupAgencyAdmin = new Role();
        roleGroupAgencyAdmin.setName("Admin");
        roleGroupAgencyAdmin.setCode("AGENCY_ADMIN");
        robeRoleRepository.save(roleGroupAgencyAdmin);

        Agency agency1 = new Agency();
        agency1.setName("Demo Sigorta");
        agencyDao.create(agency1);

        AgencyUser agencyUserQ = new AgencyUser();
        agencyUserQ.setUsername("admin");
        agencyUserQ.setPassword("96cae35ce8a9b0244178bf28e4966c2ce1b8385723a96a6b838858cdd6ca0a1e");
        agencyUserQ.setActive(true);
        agencyUserQ.setRole(roleGroup);
        agencyUserQ.setName("admin");
        agencyUserQ.setSurname("admin");
        agencyUserQ.setAgency(agency1);
        agencyUserQ.setMobilePhone("5433148674");
        agencyUserQ.setEmail("mustafaerbin@hotmail.com");
        robeUserRepository.save(agencyUserQ);

        AgencyUser agencyUserNebula = new AgencyUser();
        agencyUserNebula.setUsername("agencyUser");
        agencyUserNebula.setPassword("96cae35ce8a9b0244178bf28e4966c2ce1b8385723a96a6b838858cdd6ca0a1e");
        agencyUserNebula.setActive(true);
        agencyUserNebula.setName("User");
        agencyUserNebula.setSurname("User");
        agencyUserNebula.setRole(roleGroupAgencyUser);
        agencyUserNebula.setAgency(agency1);
        robeUserRepository.save(agencyUserNebula);

        AgencyUser agencyAdminNebula = new AgencyUser();
        agencyAdminNebula.setUsername("agencyAdmin");
        agencyAdminNebula.setPassword("96cae35ce8a9b0244178bf28e4966c2ce1b8385723a96a6b838858cdd6ca0a1e");
        agencyAdminNebula.setActive(true);
        agencyAdminNebula.setName("Admin");
        agencyAdminNebula.setSurname("Admin");
        agencyAdminNebula.setRole(roleGroupAgencyAdmin);
        agencyAdminNebula.setAgency(agency1);
        robeUserRepository.save(agencyAdminNebula);

        Menu managerMenu = new Menu();
        managerMenu.setText("Manager");
        managerMenu.setPath("Manager");
        managerMenu.setModule("Manager");
        managerMenu.setIcon("fa-cogs");
        managerMenu.setIndex(1);
        robeMenuRepository.save(managerMenu);

        Menu userMenu = new Menu();
        userMenu.setText("Users");
        userMenu.setPath("manager/user/User");
        userMenu.setModule("User");
        userMenu.setIcon("fa-users");
        userMenu.setParent(managerMenu);
        userMenu.setIndex(2);
        robeMenuRepository.save(userMenu);

        Menu roleMenu = new Menu();
        roleMenu.setText("Role");
        roleMenu.setPath("manager/role/Role");
        roleMenu.setModule("Roles");
        roleMenu.setIcon("fa-file-text-o");
        roleMenu.setParent(managerMenu);
        roleMenu.setIndex(2);
        robeMenuRepository.save(roleMenu);

        Menu menuMenu = new Menu();
        menuMenu.setText("Menu");
        menuMenu.setPath("manager/menu/Menu");
        menuMenu.setModule("Menu");
        menuMenu.setIcon("fa-tasks");
        menuMenu.setParent(managerMenu);
        menuMenu.setIndex(3);
        robeMenuRepository.save(menuMenu);

        Menu permissionMenu = new Menu();
        permissionMenu.setText("Permissions");
        permissionMenu.setPath("manager/permission/Permission");
        permissionMenu.setModule("Permission");
        permissionMenu.setIcon("fa-cogs");
        permissionMenu.setParent(managerMenu);
        permissionMenu.setIndex(4);
        robeMenuRepository.save(permissionMenu);

        Menu siteMenu = new Menu();
        siteMenu.setText("Site");
        siteMenu.setPath("Site");
        siteMenu.setModule("Site");
        siteMenu.setIcon("fa-cogs");
        siteMenu.setIndex(2);
        robeMenuRepository.save(siteMenu);

        Menu todoMenu = new Menu();
        todoMenu.setText("Todo");
        todoMenu.setPath("app/Application");
        todoMenu.setModule("Todo");
        todoMenu.setIcon("fa-list-alt");
        todoMenu.setParent(siteMenu);
        todoMenu.setIndex(5);
        robeMenuRepository.save(todoMenu);

        Menu showcaseMenu = new Menu();
        showcaseMenu.setText("Showcase");
        showcaseMenu.setPath("app/Showcase");
        showcaseMenu.setModule("Showcase");
        showcaseMenu.setIcon("fa-rebel");
        showcaseMenu.setParent(siteMenu);
        showcaseMenu.setIndex(6);
        robeMenuRepository.save(showcaseMenu);


         //MENU İŞLEMLERİ

        Menu customerMenu = new Menu();
        customerMenu.setText("Müşteri Yönetimi");
        customerMenu.setPath("site/customer/Customer");
        customerMenu.setModule("Customer");
        customerMenu.setIcon("fa-users");
        customerMenu.setParent(siteMenu);
        customerMenu.setIndex(1);
        robeMenuRepository.save(customerMenu);

        Menu policeMenu = new Menu();
        policeMenu.setText("Poliçe Yönetimi");
        policeMenu.setPath("site/policy/Policy");
        policeMenu.setModule("Policy");
        policeMenu.setIcon("fa-file-text-o");
        policeMenu.setParent(siteMenu);
        policeMenu.setIndex(2);
        robeMenuRepository.save(policeMenu);

        Menu oldPoliceMenu = new Menu();
        oldPoliceMenu.setText("Geçmiş Poliçeler");
        oldPoliceMenu.setPath("site/oldPolicy/OldPolicy");
        oldPoliceMenu.setModule("OldPolicy");
        oldPoliceMenu.setIcon("fa-file-text-o");
        oldPoliceMenu.setParent(siteMenu);
        oldPoliceMenu.setIndex(3);
        robeMenuRepository.save(oldPoliceMenu);

        Menu agencyMenu = new Menu();
        agencyMenu.setText("Acente Yönetimi");
        agencyMenu.setPath("manager/agency/Agency");
        agencyMenu.setModule("Agency");
        agencyMenu.setIcon("fa-users");
        agencyMenu.setParent(managerMenu);
        agencyMenu.setIndex(5);
        robeMenuRepository.save(agencyMenu);

        Menu agencyUserMenu = new Menu();
        agencyUserMenu.setText("Acente Kullanıcı Yönetimi");
        agencyUserMenu.setPath("manager/agencyUser/AgencyUser");
        agencyUserMenu.setModule("AgencyUser");
        agencyUserMenu.setIcon("fa-users");
        agencyUserMenu.setParent(managerMenu);
        agencyUserMenu.setIndex(6);
        robeMenuRepository.save(agencyUserMenu);

        //ANA MANU PARAMETRELER
        Menu parameterMenu = new Menu();
        parameterMenu.setText("Parametreler");
        parameterMenu.setPath("Parameter");
        parameterMenu.setModule("Parameter");
        parameterMenu.setIcon("fa-cogs");
        parameterMenu.setIndex(3);
        robeMenuRepository.save(parameterMenu);

        Menu parameterTypeMenu = new Menu();
        parameterTypeMenu.setText("Şirket Yönetimi");
        parameterTypeMenu.setPath("parameter/company/Company");
        parameterTypeMenu.setModule("Company");
        parameterTypeMenu.setIcon("fa-cogs");
        parameterTypeMenu.setParent(parameterMenu);
        parameterTypeMenu.setIndex(1);
        robeMenuRepository.save(parameterTypeMenu);

        Menu parameterCodeMenu = new Menu();
        parameterCodeMenu.setText("Şirket Ürün Yönetimi");
        parameterCodeMenu.setPath("parameter/companyProduct/CompanyProduct");
        parameterCodeMenu.setModule("CompanyProduct");
        parameterCodeMenu.setIcon("fa-cogs");
        parameterCodeMenu.setParent(parameterMenu);
        parameterCodeMenu.setIndex(2);
        robeMenuRepository.save(parameterCodeMenu);

        Menu parameterCompanySubProduct = new Menu();
        parameterCompanySubProduct.setText("Şirket Alt Ürün Yönetimi");
        parameterCompanySubProduct.setPath("parameter/companySubProduct/CompanySubProduct");
        parameterCompanySubProduct.setModule("CompanySubProduct");
        parameterCompanySubProduct.setIcon("fa-cogs");
        parameterCompanySubProduct.setParent(parameterMenu);
        parameterCompanySubProduct.setIndex(3);
        robeMenuRepository.save(parameterCompanySubProduct);

        Permission permissionParameterTypeMenu = new Permission();
        permissionParameterTypeMenu.setPermissionType(PermissionType.MENU);
        permissionParameterTypeMenu.setMenu(parameterTypeMenu);
        permissionParameterTypeMenu.setRole(roleGroup);
        permissionRepository.save(permissionParameterTypeMenu);

        Permission permissionParameterCodeMenu = new Permission();
        permissionParameterCodeMenu.setPermissionType(PermissionType.MENU);
        permissionParameterCodeMenu.setMenu(parameterCodeMenu);
        permissionParameterCodeMenu.setRole(roleGroup);
        permissionRepository.save(permissionParameterCodeMenu);

        Permission permissionparameterCompanySubProduct = new Permission();
        permissionparameterCompanySubProduct.setPermissionType(PermissionType.MENU);
        permissionparameterCompanySubProduct.setMenu(parameterCompanySubProduct);
        permissionparameterCompanySubProduct.setRole(roleGroup);
        permissionRepository.save(permissionparameterCompanySubProduct);

        // customer menüsüne, rolü admin olanlara yetki verir.
        Permission permissionCustomer = new Permission();
        permissionCustomer.setPermissionType(PermissionType.MENU);
        permissionCustomer.setMenu(customerMenu);
        permissionCustomer.setRole(roleGroup);
        permissionRepository.save(permissionCustomer);

        Permission permissionPolice = new Permission();
        permissionPolice.setPermissionType(PermissionType.MENU);
        permissionPolice.setMenu(policeMenu);
        permissionPolice.setRole(roleGroup);
        permissionRepository.save(permissionPolice);

        Permission permissionOldPolice = new Permission();
        permissionOldPolice.setPermissionType(PermissionType.MENU);
        permissionOldPolice.setMenu(oldPoliceMenu);
        permissionOldPolice.setRole(roleGroup);
        permissionRepository.save(permissionOldPolice);

        Permission permissionParameter = new Permission();
        permissionParameter.setPermissionType(PermissionType.MENU);
        permissionParameter.setMenu(parameterMenu);
        permissionParameter.setRole(roleGroup);
        permissionRepository.save(permissionParameter);

        Permission permissionManager = new Permission();
        permissionManager.setPermissionType(PermissionType.MENU);
        permissionManager.setMenu(managerMenu);
        permissionManager.setRole(roleGroup);

        permissionRepository.save(permissionManager);

        Permission permissionUser = new Permission();
        permissionUser.setPermissionType(PermissionType.MENU);
        permissionUser.setMenu(userMenu);
        permissionUser.setRole(roleGroup);
        permissionRepository.save(permissionUser);

        Permission permissionAgency = new Permission();
        permissionAgency.setPermissionType(PermissionType.MENU);
        permissionAgency.setMenu(agencyMenu);
        permissionAgency.setRole(roleGroup);
        permissionRepository.save(permissionAgency);

        Permission permissionAgencyUser = new Permission();
        permissionAgencyUser.setPermissionType(PermissionType.MENU);
        permissionAgencyUser.setMenu(agencyUserMenu);
        permissionAgencyUser.setRole(roleGroup);
        permissionRepository.save(permissionAgencyUser);

        Permission permissionRole = new Permission();
        permissionRole.setPermissionType(PermissionType.MENU);
        permissionRole.setMenu(roleMenu);
        permissionRole.setRole(roleGroup);

        permissionRepository.save(permissionRole);

        Permission permissionMenuView = new Permission();
        permissionMenuView.setPermissionType(PermissionType.MENU);
        permissionMenuView.setMenu(menuMenu);
        permissionMenuView.setRole(roleGroup);

        permissionRepository.save(permissionMenuView);

        Permission permissionPermissionView = new Permission();
        permissionPermissionView.setPermissionType(PermissionType.MENU);
        permissionPermissionView.setMenu(permissionMenu);
        permissionPermissionView.setRole(roleGroup);

        permissionRepository.save(permissionPermissionView);

        Permission permissionSite = new Permission();
        permissionSite.setPermissionType(PermissionType.MENU);
        permissionSite.setMenu(siteMenu);
        permissionSite.setRole(roleGroup);

        permissionRepository.save(permissionSite);

        Permission permissionTodoMenu = new Permission();
        permissionTodoMenu.setPermissionType(PermissionType.MENU);
        permissionTodoMenu.setMenu(todoMenu);
        permissionTodoMenu.setRole(roleGroup);

        permissionRepository.save(permissionTodoMenu);

        Permission permissionShowCaseMenu = new Permission();
        permissionShowCaseMenu.setPermissionType(PermissionType.MENU);
        permissionShowCaseMenu.setMenu(showcaseMenu);
        permissionShowCaseMenu.setRole(roleGroup);

        permissionRepository.save(permissionShowCaseMenu);

        Permission rolePermission = new Permission();
        rolePermission.setPermissionGroup("rolePermission");
        rolePermission.setRole(roleGroup);
        rolePermission.setPermissionType(PermissionType.REST);

        permissionRepository.save(rolePermission);

        Permission menuPermission = new Permission();
        menuPermission.setPermissionGroup("menuPermission");
        menuPermission.setRole(roleGroup);
        menuPermission.setPermissionType(PermissionType.REST);

        permissionRepository.save(menuPermission);

        Permission userPermission = new Permission();
        userPermission.setPermissionGroup("userPermission");
        userPermission.setRole(roleGroup);
        userPermission.setPermissionType(PermissionType.REST);

        permissionRepository.save(userPermission);

        Permission permissionController = new Permission();
        permissionController.setPermissionGroup("permissionController");
        permissionController.setRole(roleGroup);
        permissionController.setPermissionType(PermissionType.REST);
        permissionRepository.save(permissionController);

        Customer customer1 = new Customer();
        customer1.setEmail("aaa@aaa.aaa");
        customer1.setJob("Serbest Meslek");
        customer1.setMobilePhone("5465676767");
        customer1.setName("Kamil");
        customer1.setSurname("Baş");
        customer1.setTc("12212323323");
        customer1.setAgencyUser(agencyUserQ);
        customerDao.create(customer1);

        Customer customer2 = new Customer();
        customer2.setEmail("bbb@bbb.bbb");
        customer2.setJob("Esnaf");
        customer2.setMobilePhone("5465676767");
        customer2.setName("Cafer");
        customer2.setSurname("Taş");
        customer2.setTc("12212323323");
        customer2.setAgencyUser(agencyUserQ);
        customerDao.create(customer2);

        saveCampanyAndProducts();


        saveData();
    }

    private void saveData() {

        JobControl jobControlPolicy = jobControlDao.getNew();
        jobControlPolicy.setCode("policy");
        jobControlPolicy.setStatus(true);
        jobControlPolicy.setDescription("Bitiş tarihi geçmiş poliçeleri kapatır., her ayın ilk pazartesi çalışır");
        jobControlPolicy.setCron("0 0 2 ? 1/1 MON#1 *");
        jobControlDao.create(jobControlPolicy);

        JobControl jobControlMessageMail = jobControlDao.getNew();
        jobControlMessageMail.setCode("message");
        jobControlMessageMail.setStatus(true);
        jobControlMessageMail.setDescription("Bitiş tarihi yaklamış poliçeleri kullanıcıya mail gönderir., her gün sabah 7 de çalışır");
        jobControlMessageMail.setCron("0 0 7 1/1 * ? *");
        jobControlDao.create(jobControlMessageMail);
    }

    private void saveCampanyAndProducts() {

        Company companyAnadolu = companyDao.getNew();
        companyAnadolu.setName("Anadolu Sigorta");
        companyDao.create(companyAnadolu);

        Company companyAK = companyDao.getNew();
        companyAK.setName("Ak Sigorta");
        companyDao.create(companyAK);

        CompanyProduct companyProductAnadoluArac = companyProductDao.getNew();
        companyProductAnadoluArac.setCompany(companyAnadolu);
        companyProductAnadoluArac.setName("Araç");
        companyProductDao.create(companyProductAnadoluArac);

        CompanyProduct companyProductAnadoluKonut = companyProductDao.getNew();
        companyProductAnadoluKonut.setCompany(companyAnadolu);
        companyProductAnadoluKonut.setName("Konut Sigortası");
        companyProductDao.create(companyProductAnadoluKonut);

//        CompanySubProduct companySubProductTrafih = companySubProductDao.getNew();
//        //companySubProductTrafih.setCompanyProduct(companyProductAnadoluArac);
//        companySubProductTrafih.setName("Trafik Sigortası");
//        companySubProductDao.create(companySubProductTrafih);
//
//        CompanySubProduct companySubProductTamBakim = companySubProductDao.getNew();
//        //companySubProductTamBakim.setCompanyProduct(companyProductAnadoluArac);
//        companySubProductTamBakim.setName("Tam Bakım Trafik Sigortası");
//        companySubProductDao.create(companySubProductTamBakim);

    }

}
