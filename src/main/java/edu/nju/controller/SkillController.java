package edu.nju.controller;

import edu.nju.data.model.Skill;
import edu.nju.service.SkillService;
import edu.nju.service.vo.RepositoryVO;
import edu.nju.service.vo.SignedInUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dora on 2016/8/30.
 */
@Controller
@SessionAttributes("user")
public class SkillController {

    @Autowired
    SkillService service;

    @RequestMapping("/skill/{name}/{level}")
    String showSkill(@PathVariable("name")String name, @PathVariable("level")int level, Model model, HttpSession session){
        SignedInUser user = LoginHelper.getSignInUser(session);
        List<RepositoryVO> list = null;
        Skill skill = new Skill(name,level);
        model.addAttribute("skill",skill);
        if(user!=null)
            list = service.showRecommendRepos(skill,user.getUsername());
//        List<RepositoryVO> list = new ArrayList<>();
//        RepositoryVO repo1 = new RepositoryVO();
//        repo1.setFull_name("repository1");
//        repo1.setDescription("description1");
//        repo1.setLearned(true);
//        RepositoryVO repo2 = new RepositoryVO();
//        repo2.setFull_name("repository2");
//        repo2.setDescription("description2");
//        repo2.setLearned(true);
//        RepositoryVO repo3 = new RepositoryVO();
//        repo3.setFull_name("repository3");
//        repo3.setDescription("description3");
//        repo3.setLearned(false);
//        RepositoryVO repo4 = new RepositoryVO();
//        repo4.setFull_name("repository4");
//        repo4.setDescription("description4");
//        repo4.setLearned(false);
//        list.add(repo1);
//        list.add(repo2);
//        list.add(repo3);
//        list.add(repo4);
        model.addAttribute("repos",list);
        return "skill";
    }

}
