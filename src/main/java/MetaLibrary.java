import data.JSON;
import data.XML;
import databases.Database;
import datastructures.DataStructure;
import graphs.Graph;
import machinelearning.MachineLearning;
import network.Network;
import org.jgrapht.graph.*;
import scraping.Scraper;

public class MetaLibrary {
    private Graph mGraphInstance;
    private Scraper mScraperInstance;
    private Network mNetworkInstance;
    private JSON mJSONInstance;
    private XML mXMLInstance;
    private MachineLearning mMachineLearning;
    private DataStructure mDataStructure;
    private Database mDatabase;


    public MetaLibrary() {
        this.mGraphInstance = new Graph();
        this.mScraperInstance = new Scraper();
        this.mNetworkInstance = new Network();
        this.mJSONInstance = new JSON();
        this.mXMLInstance = new XML();
        this.mMachineLearning = new MachineLearning();
        this.mDataStructure = new DataStructure();
        this.mDatabase = new Database();
    }

    public Graph Graph() {
        return this.mGraphInstance;
    }

    public Scraper Scraper() {
        return this.mScraperInstance;
    }

    public Network Network() {
        return this.mNetworkInstance;
    }

    public JSON JSON() {
        return this.mJSONInstance;
    }

    public XML XML() {
        return this.mXMLInstance;
    }

    public Database Database() {
        return mDatabase;
    }

    public MachineLearning MachineLearning() {
        return mMachineLearning;
    }

    public DataStructure DataStructure() {
        return mDataStructure;
    }
}
