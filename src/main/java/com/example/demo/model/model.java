package com.example.demo.model;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
//import jakarta.persistence.JoinColumn;
import lombok.Data;

@Data
@Entity
@Table(name="dataofE")
public class model {
	
	
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long Id;
	@Id
	private String username;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
//	
//  @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinTable(name = "user_role", 
//              joinColumns = @JoinColumn(name =  "user_id"),
//              inverseJoinColumns = @JoinColumn(name = "role_id"))
//    private List<Role> roleList = new ArrayList<>();
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLE",
            joinColumns = {
            		@JoinColumn(name = "USER_ID")
                   
            },
            inverseJoinColumns = {
            		@JoinColumn(name = "ROLE_ID")
            }
    )
	private Set<Role> role;
	
	
	

}
