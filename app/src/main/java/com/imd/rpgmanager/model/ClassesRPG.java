package com.imd.rpgmanager.model;

import java.util.ArrayList;
import java.util.List;

public class ClassesRPG {
    private String imgPath;
    private String nome;
    private String descricao;
    private List<ItemRPG> itens;

    public ClassesRPG(String nome) {
        this.nome = nome;
        this.itens = new ArrayList<ItemRPG>();

        switch (nome) {
            case "Bárbaro":
                this.descricao = "Bárbaros são guerreiros brutais que usam de sua fúria advinda de sua comunhão com ferozes espíritos animais ou de simplesmente um reservatório de raiva dentro de si, para um bárbaro a fúria é mais que uma simples emoção é um poder que nutre seu corpo.";
                this.itens.add(new ItemRPG("Machado Grande", 1));
                this.itens.add(new ItemRPG("Machado de mão", 2));
                this.itens.add(new ItemRPG("Pacote de aventureiro", 1));
                this.itens.add(new ItemRPG("Azagaia", 4));
                break;
            case "Bardo":
                this.descricao = "Nem todo menestrel cantando em uma taverna ou bobo saltitando na corte real é um bardo. Descobrir a magia escondida na música requer árduo estudo e um pouco de talento natural que a maioria dos trovadores e malabaristas não tem. A vida de um bardo é gasta vagando através dos lugares coletando conhecimento, contando histórias e vivendo da gratidão das audiências, muito parecido com qualquer outro artista. Porém, um profundo conhecimento, um nível de perícia musical e um toque de magia diferencia os bardos dos seus companheiros. ";
                this.itens.add(new ItemRPG("Pacote de diplomata", 1));
                this.itens.add(new ItemRPG("Lute", 1));
                this.itens.add(new ItemRPG("Armadura de couro", 1));
                this.itens.add(new ItemRPG("Adaga", 1));
                break;
            case "Bruxo":
                this.descricao = "Um bruxo é definido por um pacto com uma entidade transcendental, guiados por um insaciável desejo por conhecimento e poder, que os compele aos seus pactos e molda suas vidas. Essa sede leva os bruxos a fazerem seus pactos e também molda suas carreiras. Histórias de bruxos criando elos com corruptores são vastamente conhecidos. Porém, muitos bruxos servem patronos que não são abissais, como as fadas, o bruxo aprende e aumenta seu poder, ao custo de serviços ocasionais realizados em nome do seu patrono.\n";
                this.itens.add(new ItemRPG("Besta leve", 1));
                this.itens.add(new ItemRPG("Bolsa de componentes", 1));
                this.itens.add(new ItemRPG("Pacote estudioso", 1));
                this.itens.add(new ItemRPG("Armadura de couro", 1));
                this.itens.add(new ItemRPG("Adaga", 2));
                break;
            case "Clérigo":
                this.descricao = "Clérigos são intermediadores entre o mundo mortal e o distante plano dos deuses. Tão variados quanto os deuses que servem, clérigos se esforçam para ser a própria mão de seus deuses. Não é apenas um sacerdote comum, mas alguém investido de poder divino, combinam o poder mágico de curar e inspirar seus aliados com magias que ferem e debilitam seus inimigos. Eles podem causar medo e pavor, espalhar pragas ou venenos, e até lançar fogo divino para consumir seus inimigos. Para aqueles malfeitores que merecem uma maça na têmpora, o clérigo se utiliza de seu treinamento de combate para enfrentar seus inimigos corpo-a-corpo, auxiliado pelo poder divino.";
                this.itens.add(new ItemRPG("Maça", 1));
                this.itens.add(new ItemRPG("Besta leve", 1));
                this.itens.add(new ItemRPG("Pacote de sacerdote", 1));
                this.itens.add(new ItemRPG("Escurdo", 1));
                this.itens.add(new ItemRPG("Símbolo sagrado", 1));
                break;
            case "Druida":
                this.descricao = "Os druidas reverenciam a natureza acima de tudo, adquirindo suas magias e outros poderes mágicos, ou da força da natureza per si ou de uma divindade da natureza. Muitos druidas buscam uma espiritualidade mística de união transcendental com a natureza ao invés de se devotar a uma entidade divina, enquanto outros servem deuses da natureza selvagem, animais ou forças elementais. As antigas tradições druídicas, algumas vezes são chamadas de Crença Antiga, contrastando com a adoração de deuses em templos ou santuários. As magias de druida são orientadas para a natureza e para os animais – o poder da presa e garra, do sol e da lua, do fogo e da tormenta. Os druidas também adquirem a habilidade de transformarem em animais e alguns druidas fazem estudos pessoais dessa prática, chegando até mesmo ao ponto de preferirem formas animais a suas formas naturais.";
                this.itens.add(new ItemRPG("Escudo de madeira", 1));
                this.itens.add(new ItemRPG("Cimitarra", 1));
                this.itens.add(new ItemRPG("Pacote de estudioso", 1));
                this.itens.add(new ItemRPG("Armadura de couro", 1));
                this.itens.add(new ItemRPG("Pacote aventureiro", 1));
                this.itens.add(new ItemRPG("Foco druídico", 1));
                break;
            case "Feiticeiro":
                this.descricao = "Os feiticeiros são raros no mundo e é incomum encontrar um feiticeiro que não esteja envolvido na vida de aventuras de alguma forma. Pessoas com poder mágico fluindo em suas veias descobrem cedo que o poder não gosta de ficar quieto. A magia de um feiticeiro gosta de ser exercida e tem uma tendência de fluir de maneiras imprevisíveis se não for chamada, Muitas vezes, os feiticeiros têm motivações obscuras ou quixotescas que os leva a aventuras. Alguns buscam uma maior compreensão da força mágica que os infunde ou a resposta do mistério de sua origem. Outros, esperam encontrar uma forma de se livrar dele ou de liberar seu potencial máximo. Independente dos seus objetivos, os feiticeiros são tão úteis para um grupo de aventureiros quanto os magos, compensando a falta de variedade de conhecimento mágico com uma enorme flexibilidade no uso das magias que eles conhecem";
                this.itens.add(new ItemRPG("Besta leve", 1));
                this.itens.add(new ItemRPG("Bolsa de componentes", 1));
                this.itens.add(new ItemRPG("Pacote de explorador", 1));
                break;
            case "Guerreiro":
                this.descricao = "Guerreiros aprendem o básico de todos os estilos de combate. Todo guerreiro sabe brandir um machado, esgrimir com uma rapieira, empunhar uma espada longa ou uma espada grande, usar um arco ou mesmo prender inimigos em uma rede com algum grau de perícia. Da mesma forma, um guerreiro sabe usar escudos e qualquer tipo de armadura. Além do conhecimento básico, cada guerreiro se especializa em certo estilo de combate. Alguns se concentram na arquearia, outros em lutar com duas armas ao mesmo tempo e ainda existem aqueles que aprimoram suas habilidades marciais com magia. Essas combinações de ampla capacidade generalista e uma vasta especialização tornam os guerreiros combatentes superiores nos campos de batalha e masmorras.";
                this.itens.add(new ItemRPG("Cota de malha", 1));
                this.itens.add(new ItemRPG("Arma marcial", 1));
                this.itens.add(new ItemRPG("Escudo", 1));
                this.itens.add(new ItemRPG("Besta leve", 1));
                this.itens.add(new ItemRPG("Pacote de Aventureiro", 1));
                this.itens.add(new ItemRPG("Pacote de explorador", 1));
                break;
            case "Ladino":
                this.descricao = "Ladinos dedicam muito de seus recursos para se tornarem mestres em várias perícias, bem como aperfeiçoar suas habilidades em combate, adquirindo uma vasta experiência que poucos personagens podem alcançar. Muitos ladinos focam na furtividade e trapaça, enquanto outros refinam suas perícias para ajudá-los nas masmorras, como escalada, encontrar e desarmar armadilhas, e abrir fechaduras. Em combate, ladinos priorizam astúcia em vez de força bruta. O ladino sempre prefere desferir um ataque preciso, bem naquele lugar que mais machuca, do que derrubar um oponente com uma série de ataques. Ladinos possuem uma habilidade quase sobrenatural de evitar o perigo, e alguns poucos aprendem truques de magia para incrementar suas outras habilidades.";
                this.itens.add(new ItemRPG("Rapieira", 1));
                this.itens.add(new ItemRPG("Arco curto", 1));
                this.itens.add(new ItemRPG("Pacote Assaltante", 1));
                this.itens.add(new ItemRPG("Armadura de couro", 1));
                this.itens.add(new ItemRPG("Adaga", 2));
                this.itens.add(new ItemRPG("Ferramenta de ladrão", 1));
                break;
            case "Mago":
                this.descricao = "Os magos são usuários de magia soberanos, unidos e definidos como uma classe pelas magias que conjuram . Usufruindo de uma trama sutil de magia que permeia o cosmos, os magos conjuram magias explosivas de fogo, arcos de relâmpagos, enganos sutis e controle de mentes de força bruta. Sua magia invoca monstros de outros planos de existência, vislumbra o futuro ou transforma inimigos mortos em zumbis. Suas magias mais poderosas podem transformar uma substância em outra, evocar meteoros que caem do céu ou abrir portais para outros mundos, Magos vivem e morrem por suas magias. Todo o resto é secundário. Eles aprendem novas magias à medida que eles experimentam e crescem em experiência. Também podem aprender magias de outros magos, de tomos antigos ou escrituras, e de criaturas anciãs (como as fadas) que são imersas em magia.";
                this.itens.add(new ItemRPG("Bordão", 1));
                this.itens.add(new ItemRPG("Foco arcano", 1));
                this.itens.add(new ItemRPG("Pacote estudioso", 1));
                this.itens.add(new ItemRPG("Grimório", 1));

                break;
            case "Monge":
                this.descricao = "Monges fazem estudos cuidadosos da energia mágica que a maioria das tradições monásticas chama de chi. Essa energia é um elemento da mágica que inunda o multiverso – especificamente, os elementos que fluem através dos corpos vivos. Os monges atrelam esse poder dentro de si mesmos para criar efeitos mágicos e exceder a capacidade física de seus corpos, e alguns dos seus ataques especiais podem bloquear o fluxo de chi nos seus oponentes. Usando essa energia, os monges canalizam velocidade e força incríveis em seus ataques desarmados. À medida que eles ganham experiência, seu treinamento marcial e sua maestria do chi lhe confere mais poder sobre seus corpos e sobre os corpos dos seus adversários.";
                this.itens.add(new ItemRPG("Espada curta", 1));
                this.itens.add(new ItemRPG("Pacote Explorador", 1));
                this.itens.add(new ItemRPG("Dardo", 10));
                break;
            case "Paladino":
                this.descricao = "Um paladino jura defender a justiça e integridade, se manter com as coisas boas do mundo contra a invasão das trevas e caçar as forças do mal onde quer que ela se esconda. Diferentes paladinos se focam em vários aspectos da causa da justiça, mas todos estão sujeitos aos juramentos que lhes concede poder para fazer seu trabalho sagrado. Embora, muitos paladinos sejam devotos de deuses do bem, o poder de um paladino vem tanto do comprometimento com a justiça per si, quanto de um deus. Os paladinos treinam por anos para aprender as perícias de combate, dominando uma variedade de armas e armaduras. Mesmo assim, suas perícias marciais são secundárias ao poder mágico que ele empunha: o poder de curar os doentes e feridos, de destruir os cruéis e os mortos-vivos e de proteger os inocentes e aqueles que se unirem a eles na luta pela justiça.";
                this.itens.add(new ItemRPG("", 1));
                this.itens.add(new ItemRPG("", 1));
                this.itens.add(new ItemRPG("", 1));
                this.itens.add(new ItemRPG("", 1));
                this.itens.add(new ItemRPG("", 1));
                break;
            case "Patrulheiro":
                this.descricao = "Guerreiros da natureza, os patrulheiros se especializaram em caçar monstros que ameaçam as margens da civilização – assaltantes humanoides, bestas e monstruosidades devastadoras, gigantes terríveis e dragões mortais. Eles aprendem a rastrear suas presas como os predadores fazem, movendo -se silenciosamente nas florestas e se escondendo atrás de arbustos e pedregulhos. Os patrulheiros focam seu treinamento de combate em técnicas que sejam especialmente úteis contra seus inimigos favoritos específicos. Graças a sua familiaridade no ambiente selvagem, os patrulheiros adquiriram a habilidade de conjurar magias atreladas ao poder da natureza, similar ao que o druida faz. Suas magias, assim como suas habilidades de combate, enfatizam a velocidade, furtividade e caça. Os talentos e habilidades de um patrulheiro são afinados com o foco mortal na árdua tarefa de proteger as fronteiras.";
                this.itens.add(new ItemRPG("Camisão de malha", 1));
                this.itens.add(new ItemRPG("Espada curta", 2));
                this.itens.add(new ItemRPG("Pacote de explorador", 1));
                this.itens.add(new ItemRPG("Arco longo", 1));
                break;
            default:
                throw new IllegalArgumentException("Classe Inválida!");
        }
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public List<ItemRPG> getItens() {
        return itens;
    }

    public void setItens(List<ItemRPG> itens) {
        this.itens = itens;
    }
}
