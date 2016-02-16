package co.shift.pcs.user.control;

import java.util.List;
import javax.ejb.Remote;

import co.shift.pcs.to.UserTO;

@Remote
public interface IUserBasicFLR {

public List<UserTO> getAllUsers() throws Exception;
}
