package co.shift.pcs.user.control;

import java.util.List;
import javax.ejb.Remote;

import co.shift.pcs.to.UserTO;

@Remote
public interface IUserParallelizer {

public List<UserTO> getAllUsers(long pCount) throws Exception;
}
