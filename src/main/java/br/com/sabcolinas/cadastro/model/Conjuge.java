package br.com.sabcolinas.cadastro.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "conj_conjuge")
public class Conjuge {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_conj")
	//@JsonView({View.ConjugeAvancado.class})
	private Long id;
	
	@Column(name = "conj_nome", length = 100)
	//@JsonView({View.ConjugeBasico.class})
	private String nome;
	
	@Column(name = "conj_data_nasc")
	//@JsonView({View.ConjugeIntermediario.class})
	private Date dataNascimento;
	
	@Column(name = "conj_cpf")
	//@JsonView({View.ConjugeAvancado.class})
	private String cpf;
	
	@Column(name = "conj_rg", length = 10)
	//@JsonView({View.ConjugeAvancado.class})
	private String rg;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "prof_id", referencedColumnName = "id_prof")
	//@JsonView({View.ConjugeAvancado.class})
	private Profissao profissao;
	
	
	
	
	
	
	
	
	

}
