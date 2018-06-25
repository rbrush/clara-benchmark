(defproject org.toomuchcode/clara-benchmark "0.1.0-SNAPSHOT"
  :description "Clara Benchmarks"
  :url "https://github.com/rbrush/clara-examples"
  :license {:name "Eclipse Public License"
            :url "https://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.7.0"]
                 [com.cerner/clara-rules "0.19.0-SNAPSHOT" :exclusions [org.clojure/clojurescript]]
                 [clj-time "0.7.0"]
                 [org.drools/drools-core "6.0.0.Final"]
                 [org.drools/drools-compiler "6.0.0.Final"]

                 ;; An SLF4J implementation is needed by drools.
                 [org.slf4j/slf4j-simple "1.7.2"]
                 [joda-time "2.3"]
                 [criterium "0.4.3"]

                 ;; Guava used by helper functions.
                 [com.google.guava/guava "14.0.1"]

                 [org.clojure/tools.cli "0.3.1"]]

  :source-paths ["src/main/clojure"]
  :test-paths ["src/test/clojure"]
  :java-source-paths ["src/main/java"]
  :jvm-opts ["-Xmx1G" "-server"]
  :resource-paths ["src/main/resources"]
  :main clara.benchmark

  :scm {:name "git"
        :url "https://github.com/rbrush/clara-benchmark.git"}
  :pom-addition [:developers [:developer {:id "rbrush"}
                              [:name "Ryan Brush"]
                              [:url "http://www.toomuchcode.org"]]]
  :repositories [["snapshots" {:url "https://oss.sonatype.org/content/repositories/snapshots/"}]]
  :deploy-repositories [["snapshots" {:url "https://oss.sonatype.org/content/repositories/snapshots/"
                                      :creds :gpg}]])
