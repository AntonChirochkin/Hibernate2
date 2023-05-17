import model.Role;
import model.RoleType;
import model.User;
import service.RoleDao;
import service.UserDao;
import service.UserDaoImpl;
import service.RoleDaoImpl;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Application {
    static UserDao userDao = new UserDaoImpl();
    static RoleDao roleDao = new RoleDaoImpl();

    public static void main(String[] args) {

        Role developer = Role.builder().type(RoleType.DEVELOPER).build();
        Role analyst = Role.builder().type(RoleType.ANALYST).build();
        Role manager = Role.builder().type(RoleType.MANAGER).build();
        Role tester = Role.builder().type(RoleType.TESTER).build();
        Role designer = Role.builder().type(RoleType.DESIGNER).build();
        Role defaul = Role.builder().type(RoleType.DEFAULT).build();

        roleDao.add(developer);
        roleDao.add(analyst);
        roleDao.add(manager);
        roleDao.add(tester);
        roleDao.add(designer);
        roleDao.add(defaul);



        Set<Role> roles = new HashSet<>();
        roles.add(roleDao.getById(1));
        User newUser = User.builder()
                .name("Kate")
                .login("beauty")
                .password("best")
                .created(LocalDateTime.now())
                .modified(LocalDateTime.now())
                .roles(roles)
                .build();
        User added = userDao.add(newUser);
        roles.add(roleDao.getById(2));
        added.setRoles(roles);
        userDao.updateUser(added);
    }
}
