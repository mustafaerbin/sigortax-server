package com.tr.sigorta.web.cli;

import com.tr.nebula.security.api.domain.PermissionType;
import com.tr.nebula.security.db.domain.Menu;
import com.tr.nebula.security.db.domain.Permission;
import com.tr.nebula.security.db.domain.Role;
import com.tr.nebula.security.db.domain.User;
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
    private CompanySubProductDao companySubProductDao;

    @Autowired
    private AgencyUserDao agencyUserDao;

    @Autowired
    private AgencyDao agencyDao;


    public void run() {

        Role roleGroup = new Role();
        roleGroup.setName("Admin");
        roleGroup.setCode("ADMIN");
        robeRoleRepository.save(roleGroup);

        Role roleGroupCompanyUser = new Role();
        roleGroupCompanyUser.setName("user");
        roleGroupCompanyUser.setCode("USER");
        robeRoleRepository.save(roleGroupCompanyUser);

        Agency agency1 = new Agency();
        agency1.setName("Beşler Sigorta");
        agencyDao.create(agency1);

        AgencyUser user = new AgencyUser();
        user.setAgency(agency1);
        user.setOid(1L);
        user.setUsername("admin");
        user.setPassword("96cae35ce8a9b0244178bf28e4966c2ce1b8385723a96a6b838858cdd6ca0a1e");
        user.setActive(true);
        user.setName("admin");
        user.setSurname("admin");
        user.setRole(roleGroup);
        agencyUserDao.create(user);
        robeUserRepository.save(user);

        User companyUser = new User();
        companyUser.setUsername("user");
        companyUser.setPassword("96cae35ce8a9b0244178bf28e4966c2ce1b8385723a96a6b838858cdd6ca0a1e");
        companyUser.setActive(true);
        companyUser.setName("user");
        companyUser.setSurname("user");
        companyUser.setRole(roleGroupCompanyUser);
        robeUserRepository.save(companyUser);

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
        userMenu.setIndex(1);
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

        /**
         * MENU İŞLEMLERİ
         */
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

        /**
         * İZİN İŞLEMLERİ
         * add manager module permission to admin role
         */
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

        Company company1 = companyDao.getNew();
        company1.setName("Anadolu Sigorta");
        companyDao.create(company1);

        Company company2 = companyDao.getNew();
        company2.setName("Ak Sigorta");
        companyDao.create(company2);

        CompanyProduct companyProduct1 = companyProductDao.getNew();
        companyProduct1.setCompany(company1);
        companyProduct1.setName("Araç");
        companyProductDao.create(companyProduct1);

        CompanyProduct companyProduct2 = companyProductDao.getNew();
        companyProduct2.setCompany(company1);
        companyProduct2.setName("Konut Sigortası");
        companyProductDao.create(companyProduct2);

        CompanySubProduct companySubProduct1 = companySubProductDao.getNew();
        companySubProduct1.setCompanyProduct(companyProduct1);
        companySubProduct1.setName("Trafik Sigortası");
        companySubProductDao.create(companySubProduct1);

        CompanySubProduct companySubProduct2 = companySubProductDao.getNew();
        companySubProduct2.setCompanyProduct(companyProduct1);
        companySubProduct2.setName("Tam Bakım Trafik Sigortası");
        companySubProductDao.create(companySubProduct2);

        Customer customer1 = new Customer();
        customer1.setEmail("aaa@aaa.aaa");
        customer1.setJob("Serbest Meslek");
        customer1.setMobilePhone(5465676767L);
        customer1.setName("Kamil");
        customer1.setSurname("Baş");
        customer1.setTc(12212323323L);
        customer1.setAgencyUser(user);
        customerDao.create(customer1);

        Customer customer2 = new Customer();
        customer2.setEmail("bbb@bbb.bbb");
        customer2.setJob("Esnaf");
        customer2.setMobilePhone(5465676767L);
        customer2.setName("Cafer");
        customer2.setSurname("Taş");
        customer2.setTc(12212323323L);
        customer2.setAgencyUser(user);
        customerDao.create(customer2);

    }


    private void saveData() {


    }

}
